package com.maximus.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[] {-1,-1};
        int left = 0,right = nums.length - 1;
        while(left < right) {
            if(nums[left] > target || nums[right] < target)
                return new int[] {-1,-1};
            if(nums[left] < target && nums[right] > target) {
                left++;
                right--;
            }
            else if(nums[left] < target && nums[right] == target) {
                left++;
            }
            else if(nums[left] == target && nums[right] > target) {
                right--;
            }
            else if(nums[left] == target && nums[right] == target) {
                break;
            }
        }
        if(nums[left] == target && nums[right] == target)
            return new int[] {left,right};
        return new int[] {-1,-1};
    }
}
