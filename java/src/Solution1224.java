import java.util.HashMap;
import java.util.Map;

/**
 * @author maximusyoung
 * 统计出现n次的数的个数，max表示出现最多的数的个数
 * 1、所有数都出现一次，随便去掉哪个
 * 2、出现max次的数只有一个，其他数都出现max-1次
 * 3、一个数出现了一次，其他所有的数都出现了max次
 */
public class Solution1224 {
	public int maxEqualFreq(int[] nums) {
		Map<Integer, Integer> countNum = new HashMap<>();
		//统计出现n次的数的个数
		int max = 0;
		int res = 0;
		int[] n = new int[nums.length+1];
		for (int i = 0; i < nums.length; i++) {
			int ii = nums[i];
			countNum.put(ii, countNum.getOrDefault(ii, 0) + 1);
			int cn = countNum.get(ii);
			n[cn]++;
			n[cn-1]--;
			if (cn > max) {
				max = cn;
			}
			if (max == 1 ||
				max + n[max-1] * (max-1) == i + 1 ||
				n[max] * max + 1 == i + 1
			) {
				res = Math.max(res, i+1);
			}
		}
		return res;
	}
}