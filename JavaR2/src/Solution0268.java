/**
 * nums = {0,1,3}
 * 和 {0,1,2,3} 异或
 * x ^ x = 0, x ^ 0 = x
 * 最后的结果即是缺失的那个
 */
public class Solution0268 {
	public int missingNumber(int[] nums) {
		int n = nums.length;
		int res = nums[0];
		for (int i = 1; i < n; i++) {
			res = res ^ nums[i];
			res = res ^ i;
		}
		res = res ^ n;
		return res;
	}
}
