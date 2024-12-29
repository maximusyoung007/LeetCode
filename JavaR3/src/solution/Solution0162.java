package solution;

public class Solution0162 {
	//画图可以很容易看出
	// 如果mid右边的值大于mid,则峰值在mid的右边，则中点向右移动，
	// 如果mid右边的值小于mid，则峰值在mid的左边， 则中点向左移动
	public int findPeakElement(int[] nums) {
		int left = 0, right = nums.length;

		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;

			if (mid >= nums.length - 1) {
				right = mid;
			} else if (nums[mid+1] < nums[mid]) {
				//如果当前点是峰值点，直接返回
				if (mid > 0 && nums[mid] > nums[mid-1]) {
					return mid;
				}
				right = mid;
			} else if (nums[mid + 1] > nums[mid]) {
				left = mid + 1;
			}

			mid = (left + right) / 2;
		}

		return mid;
	}
}
