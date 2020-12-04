#include "0036.h"
bool Solution0036::isValidSudoku(vector<vector<char>> &board) {
    int row[9][9] = {0};
    int line[9][9] = {0};
    int area[9][9] = {0};
    for(int i = 0;i < 9;i++) {
        for(int j = 0;j < 9;j++) {
            int num = board[i][j] - '0';
            int index = (i / 3) * 3 + j / 3;
            if(row[i][num] == 1 || line[num][i] == 1 || area[index][num] == 1) {
                return false;
            }
            if(row[i][num] == 0) {
                row[i][num] = 1;
            }
            if(line[num][i] == 0) {
                line[num][i] == 1;
            }
            if(area[index][num] == 0) {
                area[num][i] = 1;
            }
        }
    }
    return true;
}