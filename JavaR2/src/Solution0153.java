/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/22      create
 */
public class Solution0153 {
	public int findMin(int[] nums) {
		int left = 0, right = nums.length - 1;

		int mid = 0, res = Integer.MAX_VALUE;

		while (left <= right) {
			mid = (left + right) / 2;
			//左边有序,那最小的就是nums[left]
			if (nums[left] <= nums[mid]) {
				if (nums[left] < res) {
					res = nums[left];
				}
				//然后再考虑一下右边
				left = mid + 1;
			} else {
				//右边有序，最小的就是nums[mid]
				if (nums[mid] < res) {
					res = nums[mid];
				}
				//再考虑一下左边
				right = mid - 1;
			}
		}

		return res;
	}
}
