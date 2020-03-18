package com.maximus.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subResult = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0);
        return result;
    }

    private void dfs(int[] candidates,int target,int begin) {
        if(target == 0) {
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int i = begin;i < candidates.length;i++) {
            if(target - candidates[i] < 0)
                break;
            if(i > begin && candidates[i] == candidates[i - 1])
                continue;
            subResult.add(candidates[i]);
            dfs(candidates,target - candidates[i],i + 1);
            subResult.remove(subResult.size() - 1);
        }
    }
}
