import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * 杨文俊         2024/8/20      create
 */
public class Solution0303 {
	public static void main(String[] args) {
		int[] nums = new int[] {-2, 0, 3, -5, 2, -1};
		NumArray numArray = new NumArray(nums);
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(1, 5));
	}

}

class NumArray {
	List<Integer> prefixSums;

	public NumArray(int[] nums) {
		prefixSums = new ArrayList<>();
		//第一位加个0，便于做减法
		prefixSums.add(0);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			prefixSums.add(sum);
		}
	}

	public int sumRange(int left, int right) {
		return prefixSums.get(right + 1) - prefixSums.get(left);
	}
}