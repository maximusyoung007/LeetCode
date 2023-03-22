#include<vector>
#include<algorithm>
using namespace std;

/*
    scores 表示分数
    ages 表示年龄
    对ages和scores排序，dp[i]表示以i结尾的得分最大值
    0 <= j < i
    1、如果 ages[i] >= ages[j], dp[i] = dp[j] + scores[i]
    2、如果 ages[i] < ages[j], i无法接在j后面，啥都不做

    初始状态：dp[i] = scores[i]
*/
int beatTeamScore(vector<int>& scores, vector<int>& ages) {
    int len = scores.size();
    vector<pair<int, int>> arr(len);
    for (int i = 0; i < len; i++) {
        arr[i].first = scores[i];
        arr[i].second = ages[i];
    }
    sort(arr.begin(), arr.end());
    int dp[len];
    for (int i = 0; i < len; i++) {
        dp[i] = arr[i].first;
    }

    for (int i = 1; i < len; i++) {
        for (int j = 0; j < i; j++) {
            if (arr[i].second >= arr[j].second) {
                dp[i] = max(dp[i], dp[j] + arr[i].first);
            } else {
                dp[i] = max(dp[i], dp[j]);
            }
        }
    }
    return dp[len - 1];
}   