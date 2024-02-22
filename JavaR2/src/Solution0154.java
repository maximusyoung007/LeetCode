/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/22      create
 */
public class Solution0154 {
	public int findMin(int[] nums) {
		int left = 0, right = nums.length - 1;

		int mid = 0, res = Integer.MAX_VALUE;

		while (left <= right) {
			mid = (left + right) / 2;

			//如果left和mid相同，左边也不一定是递增的，所以最小的可能不是left,left不断+1直到是递增的为止
			while (left < mid && nums[left] == nums[mid]) {
				if (nums[left] < res) {
					res = nums[left];
				}
				left++;
			}

			//通过left+1,mid左边一定是有序的，否则，右边一定是有序的，因此右边不需要处理
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
