#include<string>
using namespace std;

//dp[i][j]表示word1的前i个字符，word2的前j个字符
//如果word1[i]==word2[j],那么不用改变，即dp[i][j]=dp[i-1][j-1]
//如果需要替换，则表示前i-1,j-1个字符已经相等了，改变i和j位，即dp[i][j]=dp[i-1][j-1]
//如果需要插入，dp[i][j] = do[i][j-1]+1
//如果需要删除，dp[i][j] = dp[i-1][j]+1
//取三个中最小的
int minDistance(string word1, string word2) {
    int m = word1.length(), n = word2.length();

    int dp[m+1][n+1];
    
    memset(dp, 0, sizeof(dp));
    for (int i = 1; i <= m; i++) {
        dp[i][0] = i;
    }
    for (int j = 1; j <= n; j++) {
        dp[0][j] = j;
    }

    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (word1[i-1] == word2[j-1]) {
                dp[i][j] = dp[i-1][j-1];
            } else {
                dp[i][j] = min(min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
            }
        }
    }
    return dp[m][n];
}