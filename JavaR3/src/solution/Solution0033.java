package solution;

public class Solution0033 {
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length;
		int mid = (left + right) / 2;

		while (left < right) {
			if (nums[mid] == target) {
				return mid;
			}

			if (nums[mid] > target) {
				//左边有序，并且target位于left和mid之间
				if (nums[left] <= nums[mid]) {
					if (target >= nums[left]) {
						right = mid;
					} else {
						left = mid + 1;
					}
				} else {
					//7,0,1,2,4,5,6
					//左边无序，右边有序，但是target<mid，所以target只可能在左边
					right = mid;
				}
			} else if (nums[mid] < target) {
				//右边有序，且target位于mid和right之间
				if (nums[right-1] >= nums[mid]) {
					if (target <= nums[right-1]) {
						left = mid + 1;
					} else {
						right = mid;
					}
				} else {
					//右边无序，左边有序，但是target>mid,所以target只可能在右边
					left = mid + 1;
				}
			}

			mid = (left + right) / 2;
		}

		return -1;
	}
}
