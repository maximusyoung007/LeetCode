#include "0063.h"

int Solution0063::uniquePathsWithObstacles(vector<vector<int>> &obstacleGrid) {
    int n = obstacleGrid.size();
    int m = obstacleGrid[0].size();

    vector<int> a(m);
    if(obstacleGrid[0][0] == 0) {
        a[0] = 1;
    } else {
        return 0;
    }
    for(int i = 0;i < n;i++) {
        for(int j = 0;j < m;j++) {
            if(obstacleGrid[i][j] == 1) {
                a[j] = 0;
                continue;
            }
            if(j > 0) {
                a[j] = a[j] + a[j - 1];
            }
        }
    }
    return a.back();
}