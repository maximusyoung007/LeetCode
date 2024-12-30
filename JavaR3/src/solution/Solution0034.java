package solution;

public class Solution0034 {
	//nums = [5,7,7,8,8,10], target = 8
	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[] {-1,-1};
		}

		int left = 0, right = nums.length;
		int resLeft = -1, resRight = -1;

		int mid;
		while (left < right) {
			mid = (left + right) / 2;
			if (nums[mid] > target) {
				right = mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				//如果找到了等于target的，向左判断，非常直观
				if (mid == 0 || nums[mid - 1] != target) {
					resLeft = mid;
					break;
				}
				right = mid;
			}
		}

		left = 0;
		right = nums.length;

		int mid1;
		while (left < right) {
			mid1 = (left + right) / 2;

			if (nums[mid1] > target) {
				right = mid1;
			} else if (nums[mid1] < target) {
				left = mid1 + 1;
			} else {
				//如果找到了等于target的，向右判断，非常直观
				if (mid1 == nums.length - 1 || nums[mid1 + 1] != target) {
					resRight = mid1;
					break;
				}
				left = mid1 + 1;
			}
		}

		return new int[] {resLeft, resRight};
	}
}
