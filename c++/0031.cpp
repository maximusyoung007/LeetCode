#include "0031.h"
#include <algorithm>

void Solution0031 ::nextPermutation(vector<int> &nums) {
    int index1 = 0,index2 = 0;
    for(int i = nums.size() - 1;i > 0;i--) {
        if(nums[i - 1] < nums[i]) {
            index1 = i - 1;
            index2 = i;
            break;
        }
    }
    if(index1 == index2) {
        reverse(nums.begin(),nums.end());
    } else {
        for (int k = nums.size() - 1; k >= 0; k--) {
            if (nums[k] > nums[index1]) {
                int temp = nums[k];
                nums[k] = nums[index1];
                nums[index1] = temp;
                break;
            }
        }
        for (int i = index2, j = nums.size() - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}