import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/28      create
 */
public class Solution0046 {
	public List<List<Integer>> permute(int[] nums) {
		List<Integer> pr = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		boolean[] isVisited = new boolean[nums.length];
		dfs(nums, isVisited, pr, res);
		return res;
	}

	private void dfs(int[] nums, boolean[] isVisited, List<Integer> pr, List<List<Integer>> res) {

		for (int i = 0; i < nums.length; i++) {
			if (isVisited[i]) {
				continue;
			}

			pr.add(nums[i]);
			isVisited[i] = true;

			if (pr.size() == nums.length) {
				List<Integer> t = new ArrayList<>();
				t.addAll(pr);
				res.add(t);
			}

			dfs(nums, isVisited, pr, res);

			//剪枝
			pr.remove(pr.size() - 1);
			isVisited[i] = false;

		}
	}
}
