package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution0046 {
	public List<List<Integer>> permute(int[] nums) {
		List<Integer> part = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		int len = nums.length;
		boolean[] isVisited = new boolean[len];

		dfs(part, res, nums, len, isVisited);

		return res;
	}


	public void dfs(List<Integer> part, List<List<Integer>> res, int[] nums, int len, boolean[] isVisited) {
		if (part.size() == len) {
			res.add(new ArrayList<>(part));
		}

		for (int i = 0; i < len; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				part.add(nums[i]);
				dfs(part, res, nums, len, isVisited);
				part.remove(part.size()-1);
				isVisited[i] = false;
			}
		}
	}
}
