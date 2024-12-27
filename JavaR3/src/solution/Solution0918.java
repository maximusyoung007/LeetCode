package solution;

public class Solution0918 {
	//1、数连续 同52题 2、数位于nums两端，=sum-min(数连续)
	public int maxSubarraySumCircular(int[] nums) {
		int n = nums.length;
		int[] maxSubArr = new int[n];
		int[] minSubArr = new int[n];

		maxSubArr[0] = nums[0];
		minSubArr[0] = nums[0];
		int sum = nums[0];

		int max = nums[0], min = nums[0];

		int minNum = 1;

		for (int i = 1; i < n; i++) {
			if (maxSubArr[i-1] + nums[i] > nums[i]) {
				maxSubArr[i] = maxSubArr[i-1] + nums[i];
			} else {
				maxSubArr[i] = nums[i];
			}

			if (maxSubArr[i] > max) {
				max = maxSubArr[i];
			}

			if (minSubArr[i-1] + nums[i] < nums[i]) {
				minSubArr[i] = minSubArr[i-1] + nums[i];
				minNum++;
			} else {
				minSubArr[i] = nums[i];
				minNum = 1;
			}

			if (minSubArr[i] < min) {
				min = minSubArr[i];
			}

			sum += nums[i];
		}

		if (minNum == n) {
			return max;
		}
		return Integer.max(max, sum - min);

	}
}
