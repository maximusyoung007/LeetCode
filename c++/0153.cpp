#include"0153.h"
int Solution153::findMin(vector<int> &nums) {
    if(nums.size() == 0) {
        return -1;
    }
    if(nums.size() == 1) {
        return nums[0];
    }
    if(nums[0] < nums[nums.size() - 1]) {
        return nums[0];
    }
    int left = 0,right = nums.size() - 1;
    while(left <= right) {
        int mid = (left + right) / 2;
        if(nums[mid] > nums[0]) {
            left = mid;
        }
        else if(nums[mid] < nums[0]) {
            right = mid;
        }
        if(nums[mid] > nums[mid + 1]) {
            return nums[mid+1];
        } else if(nums[mid] < nums[mid - 1]) {
            return nums[mid];
        }
    }
    return -1;
}