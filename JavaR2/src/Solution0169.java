/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/20      create
 */
public class Solution0169 {
	public int[] twoSum(int[] numbers, int target) {
		int i = 0, j = numbers.length - 1;

		int sum = 0;
		while (i < j) {
			sum = numbers[i] + numbers[j];
			if (sum < target) {
				i++;
			} else if (sum > target) {
				j--;
			} else {
				break;
			}
		}
		return new int[] {i+1, j+1};
	}
}
