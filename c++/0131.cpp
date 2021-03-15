#include<vector>
#include<string>
using namespace std;

class Solution0131 {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> result;
        vector<string> partResult;
        int n = s.size();
        vector<vector<bool>> f(n, vector<bool>(n));
        for (int l = 0; l < n; l++) {
            for(int i = 0; i + l < n; i++) {
                int j = i + l;
                if (l == 0) {
                    f[i][j] = true;
                } else if (l == 1) {
                    f[i][j] = s[i] == s[j];
                } else {
                    f[i][j] = s[i] == s[j] && f[i + 1][j - 1];
                }
            }
        }
        dfs(s, 0, result, partResult, f);
        return result;
    }

    void dfs(string s, int i, vector<vector<string>>& result, vector<string>& partResult, vector<vector<bool>>& f) {
        int n = s.size();
        if (i == n) {
            result.push_back(partResult);
            return;
        }
        for (int j = i; j < n; j++) {
            if (f[i][j]) {
                partResult.push_back(s.substr(i, j - i + 1));
                dfs(s, j + 1, result, partResult, f);
                partResult.pop_back();
            }
        }
    }
};