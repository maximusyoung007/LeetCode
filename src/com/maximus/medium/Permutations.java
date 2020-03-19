package com.maximus.medium;

import java.util.*;

public class Permutations {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subResult = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        generateP(0,nums);
        return result;
    }
    void generateP(int index,int[] nums) {
        if(index == nums.length) {
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int i = 0;i < nums.length;i++) {
            if(!list.contains(nums[i])) {
                subResult.add(nums[i]);
                list.add(nums[i]);
                generateP(index + 1,nums);
                Integer d = new Integer(nums[i]);
                list.remove(d);
                subResult.remove(d);
            }
        }
    }
}
