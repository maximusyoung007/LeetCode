/**
 *给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 *
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1
 *
 * 示例 1：
 * 输入：n = 12
 * 输出：21
 *
 * 示例 2：
 * 输入：n = 21
 * 输出：-1
 *
 * 提示：
 * 1 <= n <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-greater-element-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0556 {
	public int nextGreaterElement(int n) {
		char[] cs = String.valueOf(n).toCharArray();

		int i = cs.length - 2, j = cs.length - 1;
		for (;j >= 0; i--, j--) {
			if (j != 0) {
				if (cs[i] < cs[j]) {
					break;
				}
			} else {
				return -1;
			}
		}

		int k;
		for (k = cs.length - 1; k >= 0; k--) {
			if (cs[i] < cs[k]) {
				break;
			}
		}

		char ct = cs[k];
		cs[k] = cs[i];
		cs[i] = ct;

		String s = String.valueOf(cs);
		StringBuilder sb = new StringBuilder(s.substring(j));
		sb.reverse();
		String s1 = s.substring(0, j);

		String res = s1 + sb.toString();
		long l = Long.parseLong(res);
		return l > Integer.MAX_VALUE ? -1 : (int) l;

	}

}
