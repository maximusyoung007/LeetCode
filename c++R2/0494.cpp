#include<vector>
using namespace std;

void dfs(vector<int>& nums, int target, int i, int sum, int& count);

int findTargetSumWays(vector<int>& nums, int target) {
    int count = 0;
    
    //b是指向count的地址的指针，修改b是修改的count地址的值
    int *b = &count;

    dfs(nums, target, 0, 0, *b);

    return count;
}

void dfs(vector<int>& nums, int target, int i, int sum, int& count) {
    if (i == nums.size()) {
        return;
    }

    int sum1 = sum + nums[i];
    int sum2 = sum - nums[i];

    if (sum1 == target && i == nums.size() - 1) {
        count++;
    }
    if (sum2 == target && i == nums.size() - 1) {
        count++;
    }

    dfs(nums, target, i+1, sum1, count);
    dfs(nums, target, i+1, sum2, count);

}