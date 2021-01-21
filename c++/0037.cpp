#include<vector>
using namespace std;

class Solution0037 {
public:
    void solveSudoku(vector<vector<char>>& board) {
        vector<vector<bool>> rowUsed(9,vector<bool>(10));
        vector<vector<bool>> colUsed(9,vector<bool>(10));
        vector<vector<bool>> areaUsed(9,vector<bool>(10));
        for(int row = 0; row < board.size(); row++){
            for(int col = 0; col < board[0].size(); col++) {
                int num = board[row][col] - '0';
                if(num >= 1 && num <= 9){
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    areaUsed[row / 3 * 3 + col / 3][num] = true;
                }
            }
        }
        dfs(board, rowUsed, colUsed, areaUsed, 0, 0);
    }

    bool dfs(vector<vector<char>>& board, vector<vector<bool>>& rowUsed, vector<vector<bool>>& colUsed, vector<vector<bool>>& areaUsed, int row, int col){
        if(col == board[0].size()){
            col = 0;
            row++;
            if(row == board.size()){
                return true;
            }
        }
        if(board[row][col] == '.') {
            for(int num = 1; num <= 9; num++){
                if(!(rowUsed[row][num] || colUsed[col][num] || areaUsed[row / 3 * 3 + col / 3][num])){
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    areaUsed[row / 3 * 3 + col / 3][num] = true;
                    board[row][col] = '0' + num;
                    if(dfs(board, rowUsed, colUsed, areaUsed, row, col + 1)){
                        return true;
                    }
                    board[row][col] = '.';
                    rowUsed[row][num] = false;
                    colUsed[col][num] = false;
                    areaUsed[row / 3 * 3 + col / 3][num] = false;
                }
            }
        } else {
            return dfs(board, rowUsed, colUsed, areaUsed, row, col + 1);
        }
        return false;
    }
};