#include "0046.h"
vector<vector<int>> Solution0046::permute(vector<int> &nums) {
    vector<int> curr;
    vector<vector<int>> result;
    int len = nums.size();
    vector<int> used(len,0);
    bfs(curr,used,nums,result);
    return result;
}

void Solution0046::bfs(vector<int> &curr, vector<int> &used, vector<int> &nums, vector<vector<int>>& result) {
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