#include<string>
#include<vector>
using namespace std;

class Solution0115 {
public:
    int numDistinct(string s, string t) {
        int ts = t.size(), ss = s.size();
        vector<vector<long>> dp(ts + 1, vector<long>(ss + 1, 0));
//        for (int i = 0; i <= ts; i++) {
//            dp[i][0] = 0;
//        }
        for (int j = 0; j <= ss; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= ts; i++) {
            for (int j = 1; j <= ss; j++) {
                if (t[i - 1] == s[j - 1]) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[ts][ss];
    }
};