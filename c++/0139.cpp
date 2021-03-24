#include<string>
#include<vector>
#include<algorithm>
using namespace std;

class Solution0139 {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        int n = s.size() + 1;
        vector<bool> dp(n + 1);
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                string s1 = s.substr(i, j - i);
                if(dp[i] && count(wordDict.begin(), wordDict.end(), s1) != 0) {
                    dp[j] = true;
                }
            }
        }
        return dp[n];
    }
};