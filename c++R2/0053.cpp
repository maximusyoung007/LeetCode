#include<vector>
using namespace std;

//dp[i]表示以i结尾的最长子序列的和
//如果dp[i-1]<0,dp[i]=nums[i]
//如果dp[i-1]>0,dp[i]=dp[i-1]+nums[i]
//因为只和dp[i-1]相关，可以用pre表示前一个量
int maxSubArray(vector<int>& nums) {
    int pre = nums[0];

    int res = pre;

    for (int i = 1; i < nums.size(); i++) {
        if (pre <= 0) {
            pre = nums[i];
        } else {
            pre = pre + nums[i];
        }
        if (pre > res) {
            res = pre;
        }
    }

    return res;
}