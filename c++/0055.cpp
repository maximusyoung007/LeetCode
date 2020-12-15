#include "0055.h"

bool Solution0055::canJump(vector<int> &nums) {
    int max = 0;
    for(int i = 0;i < nums.size() - 1;i++) {
        if(i <= max) {
            if (i + nums[i] > max) {
                max = i + nums[i];
            }
        }
    }
    if(max >= nums.size() - 1) {
        return true;
    }
    return false;
}
