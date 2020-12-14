#include "0054.h"

vector<int> Solution0054::spiralOrder(vector<vector<int>> &matrix) {
    vector<int> result;
    int size1 = matrix.size();
    int size2 = matrix[0].size();
    int i = 0,j = 0,add = 1,flag = 1;
    int top = 0,right = size2,bottom = size1,left = 0;
    vector<vector<int>> visited = matrix;
    for(int k1 = 0;k1 < size1;k1++) {
        for(int k2 = 0;k2 < size2;k2++) {
            visited[k1][k2] = 0;
        }
    }
    while(result.size() < (size1 * size2)) {
        if (flag == 1) {
            if(add == 1) {
                for (j = left; j < right; j += add) {
                    if(visited[i][j] == 0) {
                        result.push_back(matrix[i][j]);
                        visited[i][j] = 1;
                    } else {
                        continue;
                    }
                    if (j == (right - 1)) {
                        top += 1;
                        flag = 0;
                        break;
                    }
                }
            } else if(add == -1) {
                for(j = right - 1;j >= left;j += add) {
                    if(visited[i][j] == 0) {
                        result.push_back(matrix[i][j]);
                        visited[i][j] = 1;
                    } else {
                        continue;
                    }
                    if(j == left) {
                        bottom -= 1;
                        flag = 0;
                        break;
                    }
                }
            }

        } else if(flag == 0) {
            if(add == 1) {
                for(i = top;i < bottom;i += add) {
                    if(visited[i][j] == 0) {
                        result.push_back(matrix[i][j]);
                        visited[i][j] = 1;
                    } else {
                        continue;
                    }
                    if(i == (bottom - 1)) {
                        right = right - 1;
                        flag = 1;
                        add = add * (-1);
                        break;
                    }
                }
            } else if(add == -1) {
                for(i = bottom - 1;i >= top;i += add) {
                    if(visited[i][j] == 0) {
                        result.push_back(matrix[i][j]);
                        visited[i][j] = 1;
                    } else {
                        continue;
                    }
                    if(i == top) {
                        left += 1;
                        flag = 1;
                        add = add * (-1);
                        break;
                    }
                }
            }
        }
    }
    return result;
}