import java.util.HashMap;
import java.util.Map;

public class Solution0409 {
	public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int result = 0;
		//统计奇数个数字的个数，如果大于0，则结果+1
		int odds = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			//如果是偶数个
			if (map.get(c) % 2 == 0) {
				result += 2;
				odds--;
			} else {
				odds++;
			}
		}

		if (odds > 0) {
			result += 1;
		}
//		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//			if (entry.getValue() % 2 == 1) {
//				result += 1;
//				break;
//			}
//		}

		return result;
	}


}

