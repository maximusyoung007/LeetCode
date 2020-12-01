#include"0080.h"

int Solution0080 ::removeDuplicates(vector<int> &nums) {
    if(nums.size() == 0) return 0;
    if(nums.size() == 1) return 1;
    int i = 0,j = 1,k;
    for(k = 2;k < nums.size();k++) {
        if(nums[k] == nums[i] && nums[k] == nums[j]) {
            continue;
        } else {
            i++;
            j++;
            nums[j] = nums[k];
        }
    }
    return j+1;
}