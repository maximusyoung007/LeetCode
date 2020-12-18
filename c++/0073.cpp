#include "0073.h"

void Solution0073::setZeroes(vector<vector<int>>& matrix) {
    int line = 0,col = 0;
    int m = matrix.size();
    int n = matrix[0].size();

    for(int i = 0;i < m;i++) {
        for(int j = 0;j < n;j++) {
            if(matrix[i][j] == 0) {
                if(j == 0) {
                    line = 1;
                }
                if(i == 0) {
                    col = 1;
                }
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    for(int i = 1;i < m;i++) {
        for(int j = 1;j < n;j++) {
            if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
            }
        }
    }

    if(matrix[0][0] == 0) {
        if(line == 1) {
            for(int i = 0;i < m;i++) {
                matrix[i][0] = 0;
            }
        }
        if(col == 1) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}