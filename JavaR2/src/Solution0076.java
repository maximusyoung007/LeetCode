import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/20      create
 */
public class Solution0076 {
	public String minWindow(String s, String t) {
		Map<Character, Integer> m = new HashMap<>();
		//使用count记录是否所有t中的字符都包括了,m中字符个数都是0，并且count=0,表示满足
		int count = t.length();

		for (int i = 0; i < t.length(); i++) {
			m.put(t.charAt(i), m.getOrDefault(t.charAt(i), 0) + 1);
		}

		int resLen = 0, minLen = Integer.MAX_VALUE;
		int left = 0, right = 0;
		int minLeft = 0, minRight = -1;
		for (;right < s.length(); right++) {
			if (m.containsKey(s.charAt(right))) {
				//大于0表示还有位置可以表示t中字符
				if (m.get(s.charAt(right)) > 0) {
					count--;
				}
				m.put(s.charAt(right), m.get(s.charAt(right))-1);
			}

			if (count == 0) {
				//小于0表示删除了依然满足
				while (!m.containsKey(s.charAt(left)) || (m.containsKey(s.charAt(left)) && m.get(s.charAt(left)) < 0)) {
					if (m.containsKey(s.charAt(left))) {
						m.put(s.charAt(left), m.get(s.charAt(left)) + 1);
					}
					left++;
				}
				resLen = right - left + 1;
				if (resLen < minLen) {
					minLen = resLen;
					minLeft = left;
					minRight = right;
				}
				m.put(s.charAt(left), m.get(s.charAt(left))+1);
				left++;
				count++;
			}
		}
		return s.substring(minLeft, minRight + 1);
	}
}
