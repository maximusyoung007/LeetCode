#include<string>
#include<vector>
using namespace std;

//dp[i][j]表示以word1的第i位结尾，word2的第j位结尾，最长公共子序列是多少位
//如果word1[i]=word[j],则dp[i][j]=dp[i-1][j-1]+1
//如果word[i]!=word[j],则dp[i][j]为dp[i-1][j-1],dp[i-1][j],dp[i][j-1]三者中最大的
//因为dp[i-1][j-1]一定小于dp[i-1][j]和dp[i][j-1],
//所以dp[i][j]=max(dp[i-1][j],dp[i][j-1])
//删除的字符即为最长公共子序列剩下的
int minDistance2(string word1, string word2) {
    int m = word1.length(), n = word2.length();

    //C++标准规定，连续的右尖括号" >> "在不加空格的情况下会被解析为移位运算符，
    //而在模板或容器中应被解析为两个独立的右尖括号">>
    vector<vector<int> > dp(m+1, vector<int>(n+1, 0));

    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (word1[i-1] == word2[j-1]) {
                dp[i][j] = dp[i-1][j-1] + 1;
            } else {
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
    return m + n - 2 * dp[m][n];
}