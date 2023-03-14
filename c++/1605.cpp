#include<vector>
#include<algorithm>
using namespace std;

vector<vector<int>> restoreMatrix(vector<int> &rowSum, vector<int>& colSum) {
    vector<vector<int>> res;
    int m = rowSum.size();
    int n = colSum.size();
    for (int i = 0; i < m; i++) {
        vector<int> ps;
        for (int j = 0; j < n; j++) {
            int minN = min(rowSum[i], colSum[j]);
            ps.push_back(minN);
            rowSum[i] -= minN;
            colSum[j] -= minN;
        }
        res.push_back(ps);
        ps.clear();
    }
    return res;
}