package solution;

public class Solution0053 {
	public int maxSubArray(int[] nums) {
		int n = nums.length;
		int[] currentNum = new int[n];

		currentNum[0] = nums[0];
		int max = currentNum[0];

		for (int i = 1; i < nums.length; i++) {
			if (currentNum[i-1] + nums[i] > nums[i]) {
				currentNum[i] = currentNum[i-1] + nums[i];
			} else {
				currentNum[i] = nums[i];
			}

			if (currentNum[i] > max) {
				max = currentNum[i];
			}
		}

		return max;
	}
}
