#include"0035.h"
using namespace std;
int Solution0035::searchInsert(vector<int> &nums, int target) {
    int i = 0;
    for(i = 0;i < nums.size();i++) {
        if(nums[i] >= target) return i;
        if(i < nums.size() - 1) {
            if (target > nums[i] && target < nums[i + 1]) {
                return i + 1;
            }
        }
        else {
            return i + 1;
        }
    }
    return i;
}