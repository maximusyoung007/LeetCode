#include "0039.h"
#include<algorithm>
vector<vector<int>> Solution39 ::combinationSum(vector<int> &candidates, int target) {
    vector<int> path;
    vector<vector<int>> resultList;
    vector<vector<int>> result;
    dfs(candidates,target,path,resultList,0);
    return resultList;
}

void Solution39::dfs(vector<int> &candidate, int target, vector<int> &path, vector<vector<int>> &resultList,int begin) {
    if(target < 0) {
        return;
    }
    if(target == 0) {
        resultList.push_back(path);
    }
    for(int i = begin;i < candidate.size();i++) {
        target = target - candidate[i];
        path.push_back(candidate[i]);
        dfs(candidate,target,path,resultList,i);
        path.pop_back();
        target = target + candidate[i];
    }
}