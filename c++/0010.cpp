#include <vector>
#include <string>
using namespace std;

class Solution0010 {
public:
    bool isMatch(string s, string p) {
        int len1 = s.size();
        int len2 = p.size();
        bool dp[40][40] = {false};
        dp[0][0] = true;
        for(int j = 2;j <= len2;j++) {
            dp[0][j] = p[j - 1] == '*' && dp[0][j - 2];
        }
//        for(int i = 1;i <= len1;i++) {
//            dp[i][0] = false;
//        }

        for(int i = 1;i <= len1;i++) {
            for(int j = 1;j <= len2;j++) {
                if (p[j - 1] != '*') {
                    if(p[j - 1] == '.' || p[j - 1] == s[i - 1]) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if(j > 1 && p[j - 2] != s[i - 1] && p[j - 2] != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[len1][len2];
    }
};