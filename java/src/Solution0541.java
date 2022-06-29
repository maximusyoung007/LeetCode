/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 *
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 */
public class Solution0541 {
	public String reverseStr(String s, int k) {
		StringBuilder sb = new StringBuilder("");

		while (s.length() > 2 * k) {
			StringBuilder sb1 = new StringBuilder(s.substring(0, k));
			StringBuilder sb2 = new StringBuilder(s.substring(k, 2 * k));
			StringBuilder sb3 = new StringBuilder(s.substring(2 * k));
			sb.append(sb1.reverse()).append(sb2);
			s = sb3.toString();
		}

		if (s.length() < k) {
			sb.append(new StringBuilder(s).reverse());
		} else if (s.length() >= k) {
			sb.append(new StringBuilder(s.substring(0, k)).reverse());
			sb.append(new StringBuilder(s.substring(k)));
		}

		return sb.toString();
	}
}