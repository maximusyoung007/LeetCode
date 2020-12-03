#include "0081.h"
bool Solution0081::search(vector<int> &nums, int target) {
    if(nums.size() == 0) {
        return false;
    }
    if(nums.size() == 1) {
        if(nums[0] == target) {
            return true;
        } else {
            return false;
        }
    }
    int left = 0,right = nums.size() - 1;
    while(left <= right) {
        int mid = (left + right) / 2;
        if(nums[mid] == target) {
            return true;
        }
        if(nums[left] == nums[mid]) {
            left++;
            continue;
        }
        if(nums[right] == nums[mid]) {
            right--;
            continue;
        }
        if(nums[left] <= nums[mid]) {
            if(nums[left] <= target && nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else if(nums[mid] <= nums[right]) {
            if(nums[mid] < nums[right]) {
                if(nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
    }
    return false;
}