#include "0047.h"
#include<set>
vector<vector<int>> Solution0047::permuteUnique(vector<int> &nums) {
    vector<int> curr;
    vector<vector<int>> result;
    int len = nums.size();
    vector<int> used(len,0);
    bfs(curr,used,nums,result);
    set<vector<int>> s(result.begin(),result.end());
    result.assign(s.begin(),s.end());
    return result;
}

void Solution0047::bfs(vector<int> &curr, vector<int> &used, vector<int> &nums, vector<vector<int>>& result) {
    if(curr.size() == nums.size()) {
        result.push_back(curr);
    }

    for(int i = 0;i < nums.size();i++) {
        if(used[i] == 0) {
            used[i] = 1;
            curr.push_back(nums[i]);
            bfs(curr,used,nums,result);
            used[i] = 0;
            curr.pop_back();
        }
    }
}