package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution0224 {
	public int calculate(String s) {
		//中缀转后缀
		//如果数字，直接输出
		//如果优先级比栈顶更高 则不输出、入栈
		//如果是右括号，或者优先级比栈顶小，或者优先级一样，则依次出栈并输出，直到没有元素或者遇到左括号，并将当前元素入栈
		//如果是左括号，入栈
		Stack<String> stack = new Stack<>();

		s = s.replaceAll(" ", "");
		if (s.charAt(0) == '-') {
			s = "0" + s;
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '-' && s.charAt(i-1) == '(') {
				s = s.substring(0, i) + "0" + s.substring(i);
			}
		}

		List<String> sb = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int j = i;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					i++;
				}
				sb.add(s.substring(j, i));
				i--;
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				while (!stack.isEmpty() && !"(".equals(stack.peek())) {
					String t = stack.pop();
					sb.add(t);
				}
				stack.push(String.valueOf(s.charAt(i)));
			} else if (s.charAt(i) == ')') {
				while (!stack.isEmpty() && !"(".equals(stack.peek())) {
					String t = stack.pop();
					sb.add(t);
				}
				//把左括号出栈
				stack.pop();
			} else if (s.charAt(i) == '(') {
				stack.push("(");
			}
		}

		while (!stack.isEmpty()) {
			sb.add(stack.pop());
		}

		Stack<Integer> stack1 = new Stack<>();

		for (int i = 0; i < sb.size(); i++) {
			if (sb.get(i).equals("-")) {
				int t2 = stack1.pop();
				int t1 = 0;
				if (!stack1.isEmpty()) {
					t1 = stack1.pop();
				}
				stack1.push(t1 - t2);
			} else if (sb.get(i).equals("+")) {
				int t2 = stack1.pop();
				int t1 = stack1.pop();
				stack1.push(t1 + t2);
			} else {
				stack1.push(Integer.parseInt(sb.get(i)));
			}
		}

		return stack1.peek();
	}
}
