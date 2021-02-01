#include<string>
using namespace std;

class Solution0072 {
public:
    int minDistance(string word1, string word2) {
        if(word2 == "" && word1 == "") {
            return 0;
        }
        else if(word1 == "" || word2 == "") {
            return 1;
        }
        int min = -1;
        int dp[510][510];
        if(word1[0] == word2[0]) {
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }

        bool first1 = true;
        for(int i = 1; i < word1.size(); i++) {
            if(word1[i] == word2[0]) {
                if(first1) {
                    dp[i][0] = dp[i-1][0];
                    first1 = false;
                } else {
                    dp[i][0] = dp[i-1][0] + 1;
                }
            } else {
                dp[i][0] = dp[i-1][0] + 1;
            }
        }

        bool first2 = true;
        for(int j = 1; j < word2.size(); j++) {
            if(word2[j] == word1[0]) {
                if(first2) {
                    dp[0][j] = dp[0][j-1];
                    first2 = false;
                } else {
                    dp[0][j] = dp[0][j-1];
                }
            } else {
                dp[0][j] = dp[0][j-1] + 1;
            }
        }
        for(int i = 1; i < word1.size(); i++) {
            for(int j = 1; j < word2.size(); j++) {
                if(word1[i] == word2[j]) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    min = dp[i-1][j] < dp[i-1][j-1] ? dp[i-1][j] : dp[i-1][j-1];
                    dp[i][j] = min < dp[i][j-1] ? min : dp[i][j-1];
                    dp[i][j] += 1;
                }
            }
        }
        return dp[word1.size() - 1][word2.size() - 1];
    }
};