#include<vector>
using namespace std;

class Solution0130 {
public:
    void solve(vector<vector<char>>& board) {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                if ((i == 0 || j == 0 || i == board.size() - 1 || j == board[0].size() - 1) && board[i][j] == 'O') {
                    dfs(i, j, board);
                }
            }
        }

        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(int i, int j, vector<vector<char>>& board) {
        if (i < 0 || j < 0 || i > board.size() - 1 || j > board[0].size() - 1 || board[i][j] == 'X' || board[i][j] == 'T') {
            return;
        }
        board[i][j] = 'T';
        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }
};