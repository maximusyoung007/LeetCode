package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution0022 {
	public List<String> generateParenthesis(int n) {
		String cur = "";
		List<String> res = new ArrayList<>();
		dfs(0, 0, res, cur, n);
		return res;
	}

	public void dfs(int left, int right, List<String> pr, String current, int n) {
		if (left == n) {
			for (int i = right; i < n; i++) {
				current = current + ")";
			}

			pr.add(current);
			return;
		}

		if (current.length() == n * 2) {
			pr.add(current);
			return;
		}

		if (left < n) {
			current = current + "(";
			left++;
			dfs(left, right, pr, current, n);
			left--;
			current = current.substring(0, current.length()-1);
		}

		//有足够的左括号，才加右括号
		if (right < n && left > right) {
			current = current + ")";
			right++;
			dfs(left, right, pr, current, n);
			right--;
			//current = current.substring(0, current.length()-1);
		}
	}
}
