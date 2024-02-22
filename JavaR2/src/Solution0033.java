/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/22      create
 */
public class Solution0033 {
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;

		int mid = -1;
		boolean find = false;

		while (left <= right) {
			mid = (left + right) / 2;

			if (target == nums[mid]) {
				find = true;
				break;
			}

			//左半部分有序
			if (nums[left] <= nums[mid]) {
				//左半部分有序且目标在左半部分
				if (target < nums[mid] && target >= nums[left]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				//右半部分有序且目标在右半部分
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		if (!find) {
			return -1;
		}
		return mid;
	}
}
