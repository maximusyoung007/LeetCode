import java.util.Arrays;

//找到中位数即为各个位置移动过去总和最近的
public class Solution0462 {
	public int minMoves2(int[] nums) {
		Arrays.sort(nums);

		int n = nums.length;

		int mid = 0;
		if (n % 2 != 0) {
			mid = nums[n / 2];
		} else {
			mid = (nums[n/2] + nums[n/2 - 1]) / 2;
		}

		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res += nums[i] - mid > 0 ? nums[i] - mid : mid - nums[i];
		}
		return res;
	}
}
