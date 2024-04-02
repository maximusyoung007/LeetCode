#include<vector>
using namespace std;

int findLongestChain(vector<vector<int> >& pairs) {
    sort(pairs.begin(), pairs.end());
    int n = pairs.size();

    vector<int> dp(n+1, 1);

    int res = dp[0];
    for (int i = 1; i < pairs.size(); i++) {
        for (int j = i - 1; j >= 0; j--) {
            if (pairs[j][1] < pairs[i][0]) {
                dp[i] = max(dp[i], dp[j] + 1);
                if (dp[i] > res) {
                    res = dp[i];
                }
            }
        }
    }
    return res;
}