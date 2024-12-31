package solution;

public class Solution0215 {
	public int findKthLargest(int[] nums, int k) {
		int n = nums.length;
		return threeWayQuickSortReform(0, n - 1, nums, n - k);
	}

	public int threeWayQuickSortReform(int left, int right, int[] nums, int index) {
		int base = nums[left];

		int lt = left;
		int gt = right;
		int i = left+1;

		while (i <= gt) {
			if (nums[i] < base) {
				swap(i, lt, nums);
				i++;
				lt++;
			} else if (nums[i] > base) {
				swap(i, gt, nums);
				gt--;
			} else {
				i++;
			}
		}

		if (index >= lt && index <= gt) {
			return base;
		}

		if (index < lt) {
			return threeWayQuickSortReform(left, lt - 1, nums, index);
		} else {
			return threeWayQuickSortReform(gt + 1, right, nums, index);
		}
	}

	public void threeWayQuickSort(int left, int right, int[] nums) {
		if (right <= left) {
			return;
		}
		int base = nums[left];

		int lt = left;
		int gt = right;
		int i = left+1;

		while (i <= gt) {
			if (nums[i] < base) {
				swap(i, lt, nums);
				i++;
				lt++;
			} else if (nums[i] > base) {
				swap(i, gt, nums);
				gt--;
			} else {
				i++;
			}
		}

		threeWayQuickSort(left, lt-1, nums);
		threeWayQuickSort(gt+1, right, nums);
	}

	public void swap(int left, int right, int[] nums) {
		int t = nums[right];
		nums[right] = nums[left];
		nums[left] = t;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {5,2,7,5,5,3,8};
		Solution0215 solution0215 = new Solution0215();
		solution0215.threeWayQuickSort(0, nums.length-1, nums);

		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
