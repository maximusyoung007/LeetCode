#include <vector>
#include <string>
using namespace std;

class Solution0052 {
public:
    int totalNQueens(int n) {
        vector<vector<string>> result;
        vector<string> partResult(n);
        dfs(result, 0, n, partResult);
        return result.size();
    }

    void dfs(vector<vector<string>>& result, int row, int n, vector<string>& partResult) {
        //如果最后一行也成功
        if(row == n) {
            result.push_back(partResult);
            return;
        }

        for(int i = 0; i < n; i++) {
            string s = "";
            if(judge(row, i, n, partResult)) {
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        s = s + "Q";
                    } else {
                        s = s + ".";
                    }
                }
                partResult[row] = s;
                dfs(result, row + 1, n, partResult);
            }
            s = "";
            for(int j = 0; j < n; j++) {
                s += ".";
            }
            partResult[row] = s;
        }
    }

    //判断某个节点的列、斜线上是否有其他皇后。因为row逐行增加，所以只需要考虑小于row的
    bool judge(int row, int column, int n, vector<string> &v) {
        //列
        for(int i = row; i >= 0; i--) {
            if(i != row) {
                if (v[i][column] == 'Q')
                    return false;
            }
        }
        //左斜线
        for(int i = row, j = column; i >= 0 && j >= 0;i--,j--) {
            if(i != row && j != column) {
                if (v[i][j] == 'Q')
                    return false;
            }
        }
        //右斜线
        for(int i = row, j = column; i >= 0 && j < n; i--, j++) {
            if(i != row && j != column) {
                if (v[i][j] == 'Q')
                    return false;
            }
        }
        return true;
    }
};