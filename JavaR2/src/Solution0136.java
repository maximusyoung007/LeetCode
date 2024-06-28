/**
 *  x ^ x = 0
 *  x ^ 0 = x
 */
public class Solution0136 {
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result = result ^ nums[i];
		}

		return result;
	}
}
