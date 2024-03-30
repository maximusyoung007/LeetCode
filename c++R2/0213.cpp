#include<vector>
#include<cstring>
using namespace std;

//dp[n]表示抢到了第n家，可以抢，也可以不抢，
//如果抢，则dp[n] = dp[n-2]+1
//如果不抢，dp[n] = dp[n-1]
//如果从第1家开始抢，则抢到dp[n-1]
//如果从第2家开始抢，则可以抢到dp[n]
int rob(vector<int>& nums) {
    int n = nums.size();
    int dp[n];

    memset(dp, 0, n);

    if (n == 1) {
        return nums[0];
    } else if (n == 2) {
        return max(nums[0], nums[1]);
    }

    int res = 0;

    dp[0] = nums[0];
    dp[1] = nums[0];

    for (int i = 2; i < n-1; i++) {
        dp[i] = max(dp[i-1], dp[i-2] + nums[i]);
    }

    res = dp[n-2];

    dp[0] = 0;
    dp[1] = nums[1];
    dp[2] = max(nums[1], nums[2]);

    if (n > 3) {
        for (int i = 3; i < n; i++) {
            dp[i] = max(dp[i-1], dp[i-2] + nums[i]);
        }
    }

    if (dp[n-1] > res) {
        res = dp[n-1];
    }

    return res;

}