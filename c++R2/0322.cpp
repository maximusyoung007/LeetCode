#include<vector>
using namespace std;

//dp[j]表示组成金额j需要的最少的硬币数量
int coinChange(vector<int>& coins, int amount) {
    int dp[amount+1];
    memset(dp, -1, sizeof(dp));
    dp[0] = 0;

    int coin = 0;
    for(int i = 0; i < coins.size(); i++) {
        coin = coins[i];
        for(int j = coin; j <= amount; j++) {
            //减去当前硬币，j-coin，如果dp[j-coin] != -1,说明j-coin位置有可以组成的
            //如果j没有硬币，或者j-coin
            if (dp[j-coin] != -1) {
                if (dp[j] == -1 || dp[j-coin]+1 < dp[j]) {
                    dp[j] = dp[j-coin] + 1;
                }
            }
        }
    }

    return dp[amount];
}