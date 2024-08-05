import java.util.TreeSet;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/8/5      create
 *
 */
public class Solution0128 {
	public int longestConsecutive(int[] nums) {
		TreeSet<Integer> set = new TreeSet<>();

		for (int num : nums) {
			set.add(num);
		}

		int max = 0;

		for (Integer s : set) {
			//如果s-1不在set中，则s可以作为一个连续序列的开头
			if (!set.contains(s - 1)) {
				int next = s + 1, start = s;

				while (set.contains(next)) {
					next++;
				}

				max = max > next - start ? max : next - start;
			}
		}

		return max;
	}
}
