/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/20      create
 */
public class Solution0088 {
	//从末尾开始,从大到小复制
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int res = m + n - 1;
		m--;
		n--;

		while (m >= 0 && n >= 0) {
			if (nums1[m] >= nums2[n]) {
				nums1[res] = nums1[m];
				m--;
			} else if (nums1[m] < nums2[n]) {
				nums1[res] = nums2[n];
				n--;
			}
			res--;
		}

		while (n >= 0) {
			nums1[res] = nums2[n];
			n--;
			res--;
		}

	}
}
