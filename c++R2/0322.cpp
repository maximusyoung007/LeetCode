#include<vector>
using namespace std;

//dp[j]表示组成金额j需要的最少的硬币数量
int coinChange(vector<int>& coins, int amount) {
    int dp[amount+1] = {};

    int coin = 0;
    for(int i = 0; i < coins.size(); i++) {
        coin = coins[i];
        for(int j = amount; j >= coin; j--) {
            if (dp[j-coin]+1 > dp[j]) {
                dp[j] = dp[j-coin] + 1;
            }
        }
    }

    return dp[amount];
}