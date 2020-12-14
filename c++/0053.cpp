#include "0053.h"

int Solution0053::maxSubArray(vector<int> &nums) {
    int pre = 0,maxn = nums[0];
    for(int i = 0;i < nums.size();i++) {
        if(pre + nums[i] > nums[i]) {
            pre = pre + nums[i];
        } else {
            pre = nums[i];
        }
        if(pre > maxn) {
            maxn = pre;
        }
    }
    return maxn;
}