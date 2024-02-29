import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/29      create
 */
public class Solution0047 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
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

			//和前一个数相等且前一个数没有访问，则表示是从后一个数开始遍历的
			//这两个数相同，第一轮已经从第一个数遍历过了，因此从第二个数遍历就不需要了
			if (i > 1 && nums[i] == nums[i-1] && !isVisited[i-1]) {
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
