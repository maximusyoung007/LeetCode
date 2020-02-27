package com.maximus.medium;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        if(target > nums[0]) {
            for(int i = 0; i < nums.length;i++) {
                if(nums[i] == target)
                    return i;
            }
        }
        else if(target < nums[0]) {
            for(int i = nums.length - 1;i >= 0;i--) {
                if(nums[i] == target)
                    return i;
            }
        }
        else
            return 0;
        return -1;
    }
}
