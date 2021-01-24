#include<string>
#include<vector>
using namespace std;

class Solution0044 {
public:
    bool isMatch(string s, string p) {
        int m = s.size(),n = p.size();
        vector<vector<bool>> dp(m+1, vector<bool> (n+1));
        dp[0][0] = true;
        if(m == 0 && n == 0) {
            return dp[0][0];
        }
        for(int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }
        for(int j = 1; j <= n; j++) {
            dp[0][j] = p[j - 1] == '*' && dp[0][j - 1];
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(p[j-1] >= 'a' && p[j-1] <= 'z') {
                    dp[i][j] = s[i-1] == p[j-1] && dp[i-1][j-1];
                } else if(p[j-1] == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(p[j-1] == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
};