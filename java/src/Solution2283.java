import java.util.HashMap;
import java.util.Map;

public class Solution2283 {
	public boolean digitCount(String num) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			map.put(c - '0', map.getOrDefault(c - '0', 0) + 1);
		}

		for (int i = 0; i < num.length(); i++) {
			int n = num.charAt(i) - '0';
			if (map.get(i) == null) {
				if (n != 0) {
					return false;
				}
			} else {
				if (!Integer.valueOf(n).equals(map.get(i))) {
					return false;
				}
			}
		}
		return true;
	}
}
