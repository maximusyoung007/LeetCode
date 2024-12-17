package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0017 {
	public List<String> letterCombinations(String digits) {
		Map<String, List<String>> map = new HashMap<>();

		map.put("2", new ArrayList<>() {{add("a");add("b");add("c");}});
		map.put("3", new ArrayList<>() {{add("d");add("e");add("f");}});
		map.put("4", new ArrayList<>() {{add("g");add("h");add("i");}});
		map.put("5", new ArrayList<>() {{add("j");add("k");add("l");}});
		map.put("6", new ArrayList<>() {{add("m");add("n");add("o");}});
		map.put("7", new ArrayList<>() {{add("p");add("q");add("r");add("s");}});
		map.put("8", new ArrayList<>() {{add("v");add("t");add("u");}});
		map.put("9", new ArrayList<>() {{add("z");add("w");add("x");add("y");}});

		int size = digits.length();

		List<String> res = new ArrayList<>();

		dfs(digits, 0, "", size, res, map);

		return res;
	}

	public void dfs(String digits, int index, String pr, int size, List<String> res, Map<String, List<String>> map) {
		if (index >= size) {
			return;
		}

		String digit = digits.substring(index, index+1);
		List<String> numbers = map.get(digit);

		for (String number : numbers) {
			pr = pr + number;

			if (pr.length() == size) {
				res.add(pr);
			} else {
				dfs(digits, index + 1, pr, size, res, map);
			}

			pr = pr.substring(0, pr.length()-1);
		}

	}
}
