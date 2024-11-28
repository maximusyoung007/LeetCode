package solution;

import java.util.Stack;

public class Solution0150 {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();

		for (String token : tokens) {
			if ("+".equals(token)) {
				int t1 = stack.pop();
				int t2 = stack.pop();
				stack.push(t1 + t2);
			} else if ("-".equals(token)) {
				int t1 = stack.pop();
				int t2 = stack.pop();
				stack.push(t2 - t1);
			} else if ("*".equals(token)) {
				int t1 = stack.pop();
				int t2 = stack.pop();
				stack.push(t1 * t2);
			} else if ("/".equals(token)) {
				int t1 = stack.pop();
				int t2 = stack.pop();
				stack.push(t2 / t1);
			}  else {
				stack.push(Integer.parseInt(token));
			}
		}

		return stack.peek();
	}

}
