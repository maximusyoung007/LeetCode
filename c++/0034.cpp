#include "0034.h"

vector<int> Solution0034::searchRange(vector<int>& nums, int target) {
    if(nums.size() == 0) {
        vector<int> v{-1,-1};
        return v;
    }
    int left = 0,right = nums.size() - 1,resultLeft = 0;
    while(left <= right) {
        int mid = (left + right) / 2;
        if(nums[mid] >= target) {
            right = mid - 1;
            resultLeft = mid;
        } else {
            left = mid + 1;
        }
    }

    left = 0,right = nums.size() - 1;
    int resultRight = nums.size();
    while(left <= right) {
        int mid = (left + right) / 2;
        if(nums[mid] > target) {
            right = mid - 1;
            resultRight = mid;
        } else {
            left = mid + 1;
        }
    }
    resultRight -= 1;
    if(nums[resultLeft] == target && nums[resultRight] == target && resultLeft <= resultRight && resultRight < nums.size() && resultLeft >= 0) {
        vector<int> v{resultLeft,resultRight};
        return v;
    }
    return {-1,-1};
}
