#include <vector>
#include <string>
using namespace std;

class Solution0079 {
public:
    bool exist(vector<vector<char>>& board, string word) {
        int m = board.size();
        int n = board[0].size();
        vector<vector<char>> visited(m);
        string result = "";
        vector<int> v;
        for(int i = 0;i < m;i++) {
            visited[i].resize(n);
        }
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                dfs(board,i,j,word,visited,result,v,0);
                visited[i][j] = 0;
                if(v.size() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    void dfs(vector<vector<char>> &board,int i,int j,string word,vector<vector<char>> &visited,string result,vector<int>& v,int k) {
        if(v.size() > 0) {
            return;
        }
        if(board[i][j] != word[k]) {
            return;
        } else {
            result += board[i][j];
            visited[i][j] = 1;
        }
        if(result == word) {
            v.push_back(1);
            return;
        }
        if(result.size() > word.size()) {
            result.pop_back();
            return;
        }
        if(i >= 1) {
            if(visited[i-1][j] == 0) {
                k++;
                dfs(board, i - 1, j, word, visited, result, v,k);
                visited[i-1][j] = 0;
                k--;
            }
        }
        if(j >= 1) {
            if(visited[i][j-1] == 0) {
                k++;
                dfs(board, i, j - 1, word, visited, result, v,k);
                visited[i][j-1] = 0;
                k--;
            }
        }
        if(i < board.size() - 1) {
            if(visited[i+1][j] == 0) {
                k++;
                dfs(board, i + 1, j, word, visited, result, v,k);
                visited[i+1][j] = 0;
                k--;
            }
        }
        if(j < board[0].size() - 1) {
            if(visited[i][j+1] == 0) {
                k++;
                dfs(board, i, j + 1, word, visited, result, v,k);
                visited[i][j+1] = 0;
                k--;
            }
        }
    }
};

