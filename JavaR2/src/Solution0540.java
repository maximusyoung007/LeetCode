/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/22      create
 */
public class Solution0540 {
	//每一对偶数下标、奇数下标一定是相等的，
	// 如果当前mid所在的[偶数下标，奇数下标]不相等，则缺失的在mid左边
	//如果当前mid所在的[偶数下标，奇数下标]相等，则缺失的在mid右边
	//如果mid是偶数，则mid+1就是奇数；如果mid是奇数，则mid-1就是偶数
	//偶数异或是+1，奇数异或是-1
	public int singleNonDuplicate(int[] nums) {
		int left = 0, right = nums.length - 1;

		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;

			if (nums[mid] != nums[mid^1]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
