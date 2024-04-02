#include<cstring>
#include<string.h>
#include<algorithm>
using namespace std;

//dp[i]表示以i结尾的最大乘积
//将i拆成j和i-j两部分，
//如果继续拆分i-j,则dp[i]=dp[i-j]*j
//如果不拆分了，将i-j作为一个整体，则dp[i]=(i-j)*j
//取dp[i],dp[i-j]*j,(j-j)*j三者中最大的
int integerBreak(int n) {
    int dp[n+1];

    memset(dp, 0, sizeof(dp));

    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
        for (int j = 1; j < i; j++) {
            dp[i] = max(dp[i],max(j*(i-j), dp[i-j]*j));
        }
    }
    return dp[n];

}