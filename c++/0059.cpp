#include "0059.h"

vector<vector<int>> Solution0059::generateMatrix(int n) {
    int left = 0,right = n,top = 0,bottom = n;
    vector<vector<int>> result(n);
    for(int i = 0;i < result.size();i++) {
        result[i].resize(n);
    }
    vector<vector<int>> visited(n);
    for(int i = 0;i < visited.size();i++) {
        visited[i].resize(n);
    }
    int k = 1;
    while(k <= (n * n)) {
        for(int i = left;i < right;i++) {
            if(visited[top][i] == 0) {
                result[top][i] = k;
                visited[top][i] = 1;
            }
            k++;
            if(i == right - 1) {
                top++;
            }
        }
        for(int i = top;i < bottom;i++) {
            if(visited[i][right - 1] == 0) {
                result[i][right - 1] = k;
                visited[i][right - 1] = 1;
            }
            k++;
            if(i == bottom - 1) {
                right--;
            }
        }

        for(int i = right - 1;i >= left;i--) {
            if(visited[bottom - 1][i] == 0) {
                result[bottom - 1][i] = k;
                visited[bottom - 1][i] = 1;
            }
            k++;
            if(i == left) {
                bottom--;
            }
        }
        for(int i = bottom - 1;i >= top;i--) {
            if(visited[i][left] == 0) {
                result[i][left] = k;
                visited[i][left] == 1;
            }
            k++;
            if(i == top) {
                left++;
            }
        }
    }
    return result;
}