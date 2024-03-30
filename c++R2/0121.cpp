#include<vector>
#include<cstring>
using namespace std;

int maxProfit(vector<int>& prices) {
    int n = prices.size();

    int dp[n];

    memset(dp, 0, n);

    int min = INT_MAX, res = -1;
    for (int i = 0; i < n; i++) {
        if (prices[i] < min) {
            min = prices[i];
        }

        if (prices[i] - min > res) {
            res = prices[i] - min;
        }
    }

    return res;

}