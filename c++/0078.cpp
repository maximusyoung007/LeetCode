#include "0078.h"

vector<vector<int>> Solution0078::subsets(vector<int> &nums) {
    vector<vector<int>> result;
    int n = nums.size();
    vector<int> partResult;
    for(int k = 0;k <= nums.size();k++) {
        bfs(result, 0, k, n, partResult, nums);
    }
    return result;
}

void Solution0078::bfs(vector<vector<int>> &result, int begin, int k, int n, vector<int> &partResult,vector<int> &nums) {
    if(partResult.size() == k) {
        result.push_back(partResult);
        return;
    }
    for(int i = begin;i < n;i++) {
        partResult.push_back(nums[i]);
        bfs(result,i + 1,k,n,partResult,nums);
        partResult.pop_back();
    }
}