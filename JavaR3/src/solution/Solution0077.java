package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution0077 {
	public List<List<Integer>> combine(int n, int k) {
		List<Integer> pr = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		dfs(pr, res, n, k, 1);
		return res;
	}

	public void dfs(List<Integer> pr, List<List<Integer>> res, int n, int k, int start) {
		if (pr.size() == k) {
			List<Integer> r = new ArrayList<>(pr);
			res.add(r);
		}
		for (int i = start; i <= n; i++) {
			pr.add(i);
			dfs(pr, res, n, k, i+1);
			pr.remove(pr.size()-1);

		}
	}
}
