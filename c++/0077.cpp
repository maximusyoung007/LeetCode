#include "0077.h"

vector<vector<int>> Solution0077::combine(int n, int k) {
    vector<vector<int>> result;
    if(k <= 0 || n < k) {
        return result;
    }
    vector<int> partResult;
    bfs(result,1,k,n,partResult);
    return result;
}

void Solution0077::bfs(vector<vector<int>> &result,int begin, int k, int n,vector<int> &partResult) {
    if(partResult.size() == k) {
        result.push_back(partResult);
        return;
    }
    for(int i = begin;i <= n;i++) {
        partResult.push_back(i);
        bfs(result,i + 1,k,n,partResult);
        partResult.pop_back();
    }
}