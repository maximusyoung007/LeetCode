#include "0055.h"

bool Solution0055::canJump(vector<int> &nums) {
    vector<int> result;
    vector<int> visited;
    bfs(nums,0,result,visited);
    if(result.size() > 0) {
        return true;
    }
    return false;
}

void Solution0055::bfs(vector<int> &nums, int index, vector<int>& result,vector<int> &visited) {
    if(index == (nums.size() - 1)) {
        result.push_back(1);
        return;
    }
    if(index >= nums.size())
        return;

    int current = nums[index];
    for(int i = 1;i <= current;i++) {
        int nextIndex = index + i;
        if(find(visited.begin(),visited.end(),nextIndex) == visited.end()) {
            visited.push_back(i);
            bfs(nums, nextIndex, result, visited);
        } else {
            continue;
        }
    }
}