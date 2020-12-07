#include "0039.h"
#include<algorithm>
vector<vector<int>> Solution39 ::combinationSum(vector<int> &candidates, int target) {
    vector<int> path;
    vector<vector<int>> resultList;
    vector<vector<int>> result;
    dfs(candidates,target,path,resultList);
    for(int i = 0;i < resultList.size();i++) {
        vector<int> r = resultList[i];
        sort(r.begin(),r.end());
        if(find(result.begin(),result.end(),r) == result.end()) {
            result.push_back(r);
        }
    }
    return result;
}

void Solution39::dfs(vector<int> &candidate, int target, vector<int> &path, vector<vector<int>> &resultList) {
    if(target < 0) {
        return;
    }
    if(target == 0) {
        resultList.push_back(path);
    }
    for(int i = 0;i < candidate.size();i++) {
        target = target - candidate[i];
        path.push_back(candidate[i]);
        dfs(candidate,target,path,resultList);
        path.pop_back();
        target = target + candidate[i];
    }
}