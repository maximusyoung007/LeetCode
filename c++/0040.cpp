#include "0040.h"
#include<algorithm>
vector<vector<int>> Solution40 ::combinationSum2(vector<int> &candidates, int target) {
    vector<int> path;
    vector<vector<int>> resultList;
    vector<vector<int>> result;
    vector<int> inUsed;
    dfs(candidates,target,path,resultList,0);
    for(int i = 0;i < resultList.size();i++) {
        vector<int> r = resultList[i];
        sort(r.begin(),r.end());
        if(find(result.begin(),result.end(),r) == result.end()) {
            result.push_back(r);
        } else {
            continue;
        }
    }
    return result;
}

void Solution40::dfs(vector<int> &candidate, int target, vector<int> &path, vector<vector<int>> &resultList,int begin) {
    if(target < 0) {
        return;
    }
    if(target == 0) {
        resultList.push_back(path);
    }
    for(int i = begin;i < candidate.size();i++) {
        target = target - candidate[i];
        path.push_back(candidate[i]);
        dfs(candidate,target,path,resultList,i + 1);
        path.pop_back();
        target = target + candidate[i];
    }
}