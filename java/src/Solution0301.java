import java.util.ArrayList;
import java.util.List;

/**
 * @author maximusyoung
 */
public class Solution0301 {
	List<String> res = new ArrayList<>();

	public List<String> removeInvalidParentheses(String s) {
		int leftNum = 0, rightNum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				leftNum++;
			} else if (s.charAt(i) == ')') {
				if (leftNum != 0) {
					leftNum--;
				} else {
					rightNum++;
				}
			}
		}
		dfs(s, 0, leftNum, rightNum);
		return res;
	}

	void dfs(String s, int start, int leftNum, int rightNum) {
		if (leftNum == 0 && rightNum == 0) {
			if (isValid(s)) {
				res.add(s);
				return;
			}
		}
		if (leftNum + rightNum > s.length()) {
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (i != start && s.charAt(i) == s.charAt(i - 1)) {
				continue;
			}
			if (s.charAt(i) == '(' || s.charAt(i) == ')') {
				String sNew = s.substring(0, i) + s.substring(i + 1);
				if (s.charAt(i) == '(') {
					int leftNum1 = leftNum - 1;
					dfs(sNew, i, leftNum1, rightNum);
				} else {
					int rightNum1 = rightNum - 1;
					dfs(sNew, i, leftNum, rightNum1);
				}
			}
		}
	}

	boolean isValid(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
			} else if (s.charAt(i) == ')') {
				count--;
				if (count < 0) {
					return false;
				}
			}
		}
		return true;
	}
}
