#include<vector>
using namespace std;

class Solution0174 {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        vector<vector<int>> dp(dungeon.size() + 1, vector<int>(dungeon[0].size() + 1));
        for (int i = 0; i < dungeon[0].size() - 1; i++) {
            dp[dungeon.size()][i] = INT_MAX;
        }
        for (int i = 0; i < dungeon.size(); i++) {
            dp[i][dungeon[0].size()] = INT_MAX;
        }
        dp[dungeon.size() - 1][dungeon[0].size()] = 1;
        dp[dungeon.size()][dungeon[0].size() - 1] = 1;
        for (int i = dungeon.size() - 1; i >= 0; i--) {
            for(int j = dungeon[0].size() - 1; j >= 0; j--) {
                dp[i][j] = max(1, min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }

};