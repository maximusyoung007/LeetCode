package com.maximus.medium;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums,int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 4)
            return result;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 1;i++) {
            for(int j = i + 1;j < nums.length;j++) {
                int a = nums[i];
                int b = nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = a + b + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(a);
                        list.add(b);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        Collections.sort(list);
                        if(!result.contains(list))
                            result.add(list);
                        left++;
                        right--;
                    }
                    if (sum < target) left++;
                    else if (sum > target) right--;
                }
            }
        }
        return result;
    }
}
