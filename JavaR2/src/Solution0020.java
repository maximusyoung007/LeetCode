import java.util.Stack;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/8/2      create
 */
public class Solution0020 {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '[' || c == '{' || c == '(') {
				stack.push(c);
			} else if (c == ']') {
				if (!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				} else {
					stack.push(c);
				}
			} else if (c == ')') {
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					stack.push(c);
				}
			} else if (c == '}') {
				if (!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				} else {
					stack.push(c);
				}
			}
		}

		return stack.isEmpty();
	}
}
