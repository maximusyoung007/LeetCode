#include<vector>
using namespace std;
/*
    dp[i][0]表示第i天持有股票，可能是前一天已经持有的，或者是今天买的
    则dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[i])
    dp[i][1]表示第i天没有持有股票, 可能是前一天就没有，或者是今天卖的
    则dp[i][1] = max(dp[i-1][1], dp[i-1][0]+prices[i]-fee)
*/
int maxProfit(vector<int>& prices, int fee) {
    // int n = prices.size();
    // vector<vector<int> > dp(n+1, vector<int>(2, 0));

    // dp[0][0] = -prices[0];
    // dp[0][1] = 0;

    // for (int i = 1; i < prices.size(); i++) {
    //     dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[i]);
    //     dp[i][1] = max(dp[i-1][1], dp[i-1][0] + prices[i] - fee);
    // }

    // return dp[n-1][1];
    int n = prices.size();

    int have = -prices[0];
    int notHave = 0;

    for (int i = 1; i < n; i++) {
        have = max(have, notHave - prices[i]);
        notHave = max(notHave, have + prices[i] - prices[i]);
    }

    return notHave;

}