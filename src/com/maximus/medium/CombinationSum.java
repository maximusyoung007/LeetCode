package com.maximus.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subResult = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return result;
    }

    private void dfs(int[] candidates,int target,int begin) {
        if (target == 0) {
            result.add(new ArrayList<>(subResult));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            subResult.add(candidates[i]);
            dfs(candidates,target - candidates[i], i);
            subResult.remove(subResult.size() - 1);
        }
    }
}