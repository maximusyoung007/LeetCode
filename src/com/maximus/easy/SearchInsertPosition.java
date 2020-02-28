package com.maximus.easy;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int mid = 0,left = 0,right = nums.length - 1;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid - 1;
            else if(nums[mid] < target) left = mid + 1;
        }
        return left;
    }
}
