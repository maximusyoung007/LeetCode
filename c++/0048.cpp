#include "0048.h"
#include <algorithm>

void Solution0048::rotate(vector<vector<int>> &matrix) {
    for(int i = 0;i < matrix.size();i++) {
        for(int j = i + 1;j < matrix.size();j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    for(int i = 0;i < matrix.size();i++) {
        reverse(matrix[i].begin(),matrix[i].end());
    }
}