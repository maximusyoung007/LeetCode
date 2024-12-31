package solution;

public class Solution0004 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;

		int k1 = (m+n+1)/2;
		int k2 = (m + n + 2) / 2;

		//奇数和偶数转化为同一种情况
		return (getKth(0, m-1, 0,n-1, nums1, nums2, k1)
			+ getKth(0, m-1,0,n-1, nums1, nums2, k2)) * 0.5;

	}

	//寻找第k个数，每次删除k/2个数，直到k=1
	public static int getKth(int start1, int end1, int start2, int end2, int[] nums1, int[] nums2, int k) {
		int len1 = end1 - start1 + 1;
		int len2 = end2 - start2 + 1;
		if (len1 == 0 && len2 != 0) {
			return nums2[start2 + k - 1];
		}
		if (len2 == 0 && len1 != 0) {
			return nums1[start1 + k - 1];
		}

		while (k > 1) {

			int i = start1 + Math.min(len1, k / 2) - 1;
			int j = start2 + Math.min(len2, k / 2) - 1;

			if (nums1[i] < nums2[j]) {
				k = k - (i - start1 + 1);
				start1 = i + 1;
			} else {
				k = k - (j - start2 + 1);
				start2 = j + 1;
			}

			len1 = end1 - start1 + 1;
			len2 = end2 - start2 + 1;

			//如果其中一个数组没有数了
			if (len1 == 0 && len2 != 0) {
				return nums2[start2 + k - 1];
			}
			if (len2 == 0 && len1 != 0) {
				return nums1[start1 + k - 1];
			}
		}

		return Math.min(nums1[start1], nums2[start2]);
	}
}
