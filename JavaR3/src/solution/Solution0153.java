package solution;

public class Solution0153 {
	//3 4 5 1 2
	//4 5 1 2 3
	//5 1 2 3 4
	//1 2 3 4 5
	//2 3 4 5 1
	public int findMin(int[] nums) {
		//mid两边一定有一边是顺序的
		int left = 0, right = nums.length-1;

		int mid = 0;

		while (left < right) {
			mid = (left + right) / 2;

			if (nums[mid] > nums[right]) {
				// 左边有序，最小值在右边
				//左边有序 1 2 3 4 5这种情况，也可以在右边有序这种中判断
				left = mid + 1;
			} else {
				//nums[mid] < nums[right] 时，说明 [mid...right] 是有序的，最小时可能是mid或者在左边
				right = mid;
			}
		}

		return nums[left];
	}
}
