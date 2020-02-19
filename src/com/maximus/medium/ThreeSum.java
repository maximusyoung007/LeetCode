package com.maximus.medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] > 0)return result;
            if(i > 0 && nums[i] == nums[i-1])continue;
            int left = i + 1,right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> subResult = new ArrayList<>();
                    while(left < right && nums[left] == nums[left+1])
                        left++;
                    while(left < right && nums[right] == nums[right-1])
                        right--;
                    subResult.add(nums[i]);
                    subResult.add(nums[left]);
                    subResult.add(nums[right]);
                    result.add(subResult);
                    left++;
                    right--;
                }
                else if(sum > 0)
                    right--;
                else if(sum < 0)
                    left++;
            }
        }
        return result;
    }
}
