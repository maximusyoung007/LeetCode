#include<cstring>
#include<cmath>

//dp[j]表示以j结尾的最少要操作几次，因为有两种操作，复制全部和粘贴，如果i可以整除j
//则表示可以由前j个粘贴i/j次得到i,则dp[i]=dp[j]+i/j
int minSteps(int n) {
    int dp[n+1];
    memset(dp, -1, sizeof(dp));

    dp[1] = 0;

    for (int i = 2; i <= n; i++) {
        for (int j = 1; j < sqrt(n); j++) {
            if (i % j == 0) {
                dp[i] = dp[j] + i / j; 
            }
        }
    }

    return dp[n];
}