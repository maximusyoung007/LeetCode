#include "0027.h"
int Solution0027 ::removeElement(vector<int> &nums, int val) {
    if(nums.size() == 0) return 0;
    int i = 0,j;
    for(j = 0;j < nums.size();j++) {
        if(nums[j] != val) {
            nums[i] = nums[j];
            i++;
        }
    }
    return i;
}