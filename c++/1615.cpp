#include<vector>
#include<map>
#include<string.h>
using namespace std;

int maximalNetworkRank(int n, vector<vector<int>>& roads) {
    int res = 0;
    map<int, int> m;
    bool change = false;
    int cal[n][n];
    memset(cal, 0, sizeof(cal));
    if (roads.size() == 0) {
        return 0;
    }
    if (n == 2) {
        return 1;
    }
    for (vector<int> v : roads) {
        m[v[0]] = m[v[0]] + 1;
        m[v[1]] = m[v[1]] + 1;
        cal[v[0]][v[1]] = 1;
        cal[v[1]][v[0]] = 1;
    }

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            res = max(res, m[i] + m[j] - cal[i][j]);
        }
    }

    return res;
}