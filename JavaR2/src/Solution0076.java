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
		int count = t.length();

		for (int i = 0; i < t.length(); i++) {
			m.put(t.charAt(i), m.getOrDefault(t.charAt(i), 0) + 1);
		}

		int left = 0, right = 0;
		for (;right < s.length(); right++) {

		}

	}
}
