package com.maximus.easy;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1;i < nums.length;i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++) {
            if(dp[i] > max)
                max = dp[i];
        }
        return max;
    }
}