#include "0036.h"
bool Solution0036::isValidSudoku(vector<vector<char>> &board) {
    int row[9][9] = {0};
    int line[9][9] = {0};
    int area[9][9] = {0};
    for(int i = 0;i < 9;i++) {
        for(int j = 0;j < 9;j++) {
            if(board[i][j] == '.') {
                continue;
            }
            int num = (board[i][j] - '0') - 1;
            int index = (i / 3) * 3 + j / 3;
            if(row[i][num] == 1 || line[j][num] == 1 || area[index][num] == 1) {
                return false;
            }
            if(row[i][num] == 0) {
                row[i][num] = 1;
            }
            if(line[j][num] == 0) {
                line[j][num] = 1;
            }
            if(area[index][num] == 0) {
                area[index][num] = 1;
            }
        }
    }
    return true;
}