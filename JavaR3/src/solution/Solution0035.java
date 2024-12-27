package solution;

public class Solution0035 {
	public int searchInsert(int[] nums, int target) {
		int left = 0, right = nums.length;
		int mid = (left + right) / 2;

		while (left < right) {
			if (nums[mid] < target) {
				left = mid+1;
			} else if (nums[mid] > target) {
				right = mid;
			} else if (nums[mid] == target) {
				return mid;
			}

			mid = (left + right) / 2;
		}

		return mid;
	}
}
