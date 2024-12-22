package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution0039 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> pr = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();

		dfs(candidates, target, 0, 0, pr, res, 0);

		return res;
	}

	public void dfs(int[] candidates, int target, int sum, int current, List<Integer> pr, List<List<Integer>> res, int start) {
		int currentSum = sum + current;
		if (currentSum == target) {
			res.add(new ArrayList<>(pr));
			return;
		}

		if (currentSum > target) {
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			pr.add(candidates[i]);
			dfs(candidates, target, currentSum, candidates[i], pr, res, i);
			pr.remove(pr.size()-1);
		}
	}
}
