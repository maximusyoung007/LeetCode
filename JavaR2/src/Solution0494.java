public class Solution0494 {
	int count = 0;

	public int findTargetSumWays(int[] nums, int target) {
		dfs(nums, target, 0, 0);

		return count;
	}

	public void dfs(int[] nums, int target, int i, int sum) {
		if (i == nums.length) {
			return;
		}

		int sum1 = sum + nums[i];
		int sum2 = sum - nums[i];

		if (sum1 == target && i == nums.length - 1) {
			count++;
		}
		if (sum2 == target && i == nums.length - 1) {
			count++;
		}

		dfs(nums, target, i+1, sum1);
		dfs(nums, target, i+1, sum2);

	}
}
