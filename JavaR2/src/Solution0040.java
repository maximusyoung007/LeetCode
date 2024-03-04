import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/3/1      create
 */
public class Solution0040 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<Integer> pr = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		boolean[] isVisited = new boolean[candidates.length];
		dfs(candidates, isVisited, pr, res, 0, target, 0);
		return res;
	}

	private void dfs(int[] nums, boolean[] isVisited, List<Integer> pr, List<List<Integer>> res,int sum, int target, int nowIdex) {

		//每次只向后搜索
		for (int i = nowIdex; i < nums.length; i++) {
			//两个数相同的情况：
			//和前一个数相等且前一个数没有访问，则表示是从后一个数开始遍历的
			//这两个数相同，第一轮第一个数已经加到target里了，不需要重复加这种情况
			//多于两个数同理
			boolean finished = false;
			for (int j = 0; j < i; j++) {
				if (nums[j] == nums[i] && !isVisited[j]) {
					finished = true;
				}
			}
			if (finished) {
				continue;
			}

			pr.add(nums[i]);
			sum += nums[i];
			isVisited[i] = true;

			if (sum >= target) {
				if (sum == target) {
					res.add(new ArrayList<>(pr));
				}
				//如果大于等于目标值，就不再向后递归了
				sum -= nums[i];
				pr.remove(pr.size() - 1);
				isVisited[i] = false;
				continue;
			}

			dfs(nums, isVisited, pr, res, sum, target, i+1);

			//剪枝
			pr.remove(pr.size() - 1);
			isVisited[i] = false;
			sum -= nums[i];

		}
	}
}
