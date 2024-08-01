/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/8/1      create
 * 0 1 2 3 4 5
 * 2 1 0 3 5 4
 * 在 2 1 0 5 4 3中，
 * 2在位置0，如果排完需后，2应该在位置2，那么2 1 0这三个位置需要一起重新排序，所以要分在一组
 * 3在位置3，排完序后也在位置3，因此可以单独一组，
 * 5在位置4，排完序后应该在位置5，所以5，4需要重新排序，需要重新分组
 *  一般的，从当前最大值的实际位置，到当前最大值的排序后位置，都需要放在一组
 *  每当当前最大值等于数组位置时，分割数+1
 */
public class Solution0769 {
	public int maxChunksToSorted(int[] arr) {
		int max = 0, res = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (max == i) {
				res++;
			}
		}
		return res;
	}
}
