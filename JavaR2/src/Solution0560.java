import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/8/21      create
 *
 * 使用map保存，key为前缀和，value为前缀和出现的次数
 * 记当前前缀和为pre,如果pre-k存在，则表示pre-k到pre的和刚好为k,满足条件；将pre-k出现的次数加到结果中
 * map初始化时，需要加上（0，1），防止出现pre-k=0时，没有对应值的情况
 */
public class Solution0560 {
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> m = new HashMap<>();
		m.put(0, 1);

		int pre = 0;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			pre += nums[i];
			//先判断 前缀和-k是否符合要求，再将当前前缀和个数加到map中
			//否则，如果k=0,则当前前缀和已经在map中了，但其实当前的前缀和并不符合
			if (m.containsKey(pre - k)) {
				res += m.get(pre - k);
			}
			m.put(pre, m.getOrDefault(pre, 0) + 1);
		}
		return res;
	}
}
