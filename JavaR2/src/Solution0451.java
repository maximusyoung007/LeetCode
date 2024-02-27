import java.util.HashMap;
import java.util.Map;

/**
 * @author maximusyoung
 */
public class Solution0451 {
	public String frequencySort(String s) {
		Map<Character, Integer> m = new HashMap<>();

		int maxIndex = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			m.put(c, m.getOrDefault(c, 0) + 1);
			if (m.get(c) > maxIndex) {
				maxIndex = m.get(c);
			}
		}

		StringBuilder[] t = new StringBuilder[maxIndex+1];

		for (Map.Entry<Character, Integer> entry : m.entrySet()) {
			StringBuilder ts = new StringBuilder();
			if (t[entry.getValue()] != null) {
				ts = t[entry.getValue()];
			}
			for (int i = 0; i < entry.getValue(); i++) {
				ts = ts.append(entry.getKey());
			}

			t[entry.getValue()] = ts;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = t.length - 1; i >= 0; i--) {
			if (t[i] != null) {
				sb = sb.append(t[i]);
			}
		}
		return sb.toString();
	}
}
