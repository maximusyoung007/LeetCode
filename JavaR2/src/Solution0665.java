/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/19      create
 */
public class Solution0665 {
	public boolean checkPossibility(int[] nums) {
		int i = 0, j = 1;
		int count = 0;

		while (i < nums.length && j < nums.length) {
			if (nums[i] > nums[j]) {
				count++;
				//如果出现i大j小的，j要尽可能小，才更有可能让j比j+1小，所以优先修改i
				//如果i-1小于j,则可以将i修改为j
				//否则，将j修改为i
				if (i == 0) {
					nums[i] = nums[j];
				} else {
					if (nums[i - 1] <= nums[j]) {
						nums[i] = nums[j];
					} else {
						nums[j] = nums[i];
					}
				}
			}
			i++;
			j++;
		}
		return count <= 1;
	}
}
