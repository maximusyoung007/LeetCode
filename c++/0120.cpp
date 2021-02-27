#include<vector>
using namespace std;

class Solution0120 {
public:
    int minimumTotal(vector<vector<int>> &triangle) {
        int n = triangle.size();
        vector<vector<int>> f(n, vector<int>(n));
        f[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    f[i][j] = f[i-1][0] + triangle[i][j];
                }
                else if (j == i) {
                    f[i][j] = f[i-1][i-1] + triangle[i][j];
                } else {
                    f[i][j] = min(f[i-1][j],f[i-1][j-1]) + triangle[i][j];
                }
            }
        }
        int minSum = f[n-1][0];
        for (int i = 1; i < n; i++) {
            if (f[n-1][i] < minSum) {
                minSum = f[n-1][i];
            }
        }
        return minSum;
    }
};