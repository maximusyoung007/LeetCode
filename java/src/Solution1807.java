import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1807 {
	public String evaluate(String s, List<List<String>> knowledge) {
		Map<String, String> m = new HashMap<>();
		for (List<String> l : knowledge) {
			m.put(l.get(0), l.get(1));
		}
		StringBuilder res = new StringBuilder();
		StringBuilder tsb = new StringBuilder();
		boolean betweenBracket = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				betweenBracket = true;
			} else if (s.charAt(i) == ')') {
				betweenBracket = false;
				if (m.containsKey(tsb.toString())) {
					res.append(m.get(tsb.toString()));
				} else {
					res.append("?");
				}
				tsb = new StringBuilder("");
			} else {
				if (betweenBracket) {
					tsb.append(s.charAt(i));
				} else {
					res.append(s.charAt(i));
				}
			}
		}
		return res.toString();
	}
}
