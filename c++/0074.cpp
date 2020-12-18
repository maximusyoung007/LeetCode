#include "0074.h"

bool Solution0074::searchMatrix(vector<vector<int>> &matrix, int target) {
    int m = matrix.size();
    if(m == 0) {
        return false;
    }
    int n = matrix[0].size();
    int begin = 0,end = (m * n) - 1;
    while(begin <= end) {
        int mid = (begin + end) / 2;
        int value = matrix[mid / n][mid % n];
        if(value > target) {
            end = mid - 1;
        } else if(value < target) {
            begin = mid + 1;
        } else {
            return true;
        }
    }
    return false;
}