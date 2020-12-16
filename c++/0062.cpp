#include "0062.h"

int Solution0062 ::uniquePaths(int m, int n) {
    vector<vector<int>> v(m);
    for(int i = 0;i < m;i++) {
        v[i].resize(n);
    }
    for(int i = 0;i < n;i++) {
        v[0][i] = 1;
    }
    for(int i = 0;i < m;i++) {
        v[i][0] = 1;
    }
    for(int i = 1;i < m;i++) {
        for(int j = 1;j < n;j++) {
            v[i][j] = v[i-1][j] + v[i][j - 1];
        }
    }
    return v[m-1][n-1];
}

//深度优先遍历，超时
//void Solution0062::bfs(int m1,int n1,vector<int>& count,int m,int n) {
//    if(m1 == m && n1 == n) {
//        count.push_back(1);
//    }
//    if(m1 < m) {
//        bfs(m1 + 1, n1, count, m, n);
//    }
//    if(n1 < n) {
//        bfs(m1, n1 + 1, count, m, n);
//    }
//}
