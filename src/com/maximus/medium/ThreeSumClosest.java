package com.maximus.medium;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosed(int[] nums,int target) {
        int result = 0,min = Integer.MAX_VALUE;
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++) {
            int left = i + 1,right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < min) {
                    result = sum;
                    min = Math.abs(sum - target);
                }
                if(sum < target)
                    left++;
                else if(sum > target)
                    right--;
                else
                    return sum;
            }
        }
        return result;
    }
}
