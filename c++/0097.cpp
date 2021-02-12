#include<string>
#include<vector>
using namespace std;

class Solution0097 {
public:
    bool isInterleave(string s1, string s2, string s3) {
        if (s1.size() + s2.size() != s3.size()) {
            return false;
        }
        vector<vector<int>> f(s1.size() + 1, vector<int>(s2.size() + 1, 0));
        f[0][0] = true;
        for (int i = 0; i <= s1.size(); i++) {
            for (int j = 0; j <= s2.size(); j++) {
                if (i > 0) {
                    if (s1[i - 1] == s3[i + j - 1]) {
                        f[i][j] |= f[i - 1][j];
                    }
                }
                if (j > 0) {
                    if (s2[j - 1] == s3[i + j - 1]) {
                        f[i][j] |= f[i][j - 1];
                    }
                }
            }
        }
        return f[s1.size()][s2.size()];
    }
};