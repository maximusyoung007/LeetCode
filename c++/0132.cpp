#include<vector>
#include<string>
using namespace std;

class Solution0132 {
public:
    int minCut(string s) {
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
        vector<int> r(n);
        for (int j = 0; j < n; j++) {
            if(f[0][j]) {
                r[j] = 0;
            } else {
                r[j] = r[j-1] + 1;
                for(int i = 1; i < j; i++) {
                    if (f[i][j]) {
                        r[j] = min(r[j], r[i - 1] + 1);
                    }
                }
            }
        }
        return r[n-1];
    }
};