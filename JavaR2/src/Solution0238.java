public class Solution0238 {
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] res = new int[len];
		for (int i = 0; i < res.length; i++) {
			res[i] = 1;
		}

		//front 记录前缀积, after记录后缀积， 如1，2，3，4，res[1] = 1 * 3 * 4 (1是前缀和，3*4是后缀和)
		int front = 1, after = 1;
		for (int i = 1; i < nums.length; i++) {
			front = front * nums[i - 1];
			res[i] = res[i] * front;
		}

		for (int j = nums.length - 2; j >= 0; j--) {
			after = after * nums[j+1];
			res[j] = res[j] * after;
		}
		return res;
	}
}
