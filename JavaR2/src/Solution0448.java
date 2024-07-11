import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/7/11      create
 */
public class Solution0448 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();

		int[] mark = new int[nums.length];

		for (int num : nums) {
			mark[num-1] = 1;
		}

		for (int i = 0; i < mark.length; i++) {
			if (mark[i] == 0) {
				res.add(i+1);
			}
		}

		return res;
	}
}
