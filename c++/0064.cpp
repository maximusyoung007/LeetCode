#include "0064.h"

int Solution0064::minPathSum(vector<vector<int>> &grid) {
    int m = grid.size();
    int n = grid[0].size();
    vector<vector<int>> v1(m);
    for(int i = 0;i < m;i++) {
        v1[i].resize(n);
    }

    v1[0][0] = grid[0][0];
    for(int i = 1;i < n;i++) {
        v1[0][i] = v1[0][i - 1] + grid[0][i];
    }
    for(int j = 1;j < m;j++) {
        v1[j][0] = v1[j - 1][0] + grid[j][0];
    }

    for(int i = 1;i < m;i++) {
        for(int j = 1;j < n;j++) {
            if(v1[i-1][j] <= v1[i][j-1]) {
                v1[i][j] = v1[i-1][j] + grid[i][j];
            } else {
                v1[i][j] = v1[i][j-1] + grid[i][j];
            }
        }
    }
    return v1[m-1][n-1];
}