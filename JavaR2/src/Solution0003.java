import java.util.HashMap;
import java.util.Map;

public class Solution0003 {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() < 1) {
			return 0;
		}
		int left = 0, right = 1;

		//已经出现的字符及出现的下标，如果再次出现,并且下标大于left当前的下标，left从这个下标后一位重新开始，并将这个字符的下标更新为right
		Map<Character, Integer> map = new HashMap<>();
		map.put(s.charAt(left), 0);

		//至少有第一个这一个字符
		int res = 1;
		while (right < s.length()) {
			if (map.containsKey(s.charAt(right))) {
				if (right - left > res) {
					res = right - left;
				}
				int index = map.get(s.charAt(right));
				if (index + 1 > left) {
					left = index + 1;
				}
			}
			map.put(s.charAt(right), right);
			right++;
		}

		//如果不同的字符串刚好包含最后一个字符
		if (right == s.length()) {
			if (right - left > res) {
				res = right - left;
			}
		}
		return res;
	}
}
