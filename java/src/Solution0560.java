public class Solution0560 {
	public int subarraySum(int[] nums, int k) {
		int n = nums.length;
		int[] sums = new int[n + 1];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			sums[i+1] = sum;
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (k == sums[j] - sums[i]) {
					res++;
				}

			}
		}
		return res;
	}
}
