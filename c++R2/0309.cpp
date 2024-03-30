#include<vector>
using namespace std;

/*
    dp[i][3], 3表示到第i位有可能的3种状态，表示第i天结束时，可能的状态
    dp[i][0],表示第i天持有股票
    dp[i][1],表示第i天没有持有股票，且进入冻结期
    dp[i][2],表示第i天没有持有股票，且没有进入冻结期

    1、如果第i天持有股票，那么可能是第i-1天买入了股票，
    也有可能是第i天买入了股票，那么第i-1天不能持有股票且没有进入冻结期
    dp[i][0]=dp[i-1][0]或者dp[i-1][2]-prices[i]
    2、如果第i天没有持有股票，且进入冻结期，表示第i天卖掉了股票，则表示第i-1天持有股票
    则dp[i][1]=dp[i-1][0] + prices[i]
    3、如果第i天没有持有股票，且没有进入冻结期，那么第i-1天没有持有股票
    dp[i][2]=dp[i-1][1]或者dp[i-1][2]
*/
int maxProfit(vector<int>& prices) {
    int n = prices.size();

    int dp[n][3];

    dp[0][0] = -prices[0];
    dp[0][1] = 0;
    dp[0][2] = 0;

    for (int i = 1; i < n; i++) {
        dp[i][0] = max(dp[i-1][0], dp[i-1][2] - prices[i]);
        dp[i][1] = dp[i-1][0] + prices[i];
        dp[i][2] = max(dp[i-1][1], dp[i-1][2]);
    }

    return max(max(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
}