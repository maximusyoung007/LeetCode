import java.util.Stack;

public class Solution0772 {
	/**
	 * 栈的应用
	 * 预处理： 每个无符号数字之前加上 "+"
	 * 1、如果是 + - 后跟数字，则作为一个整体入栈
	 * 2、如果是 * / 后跟数字，则上一个数字出栈，并与* / 后面的数字一起计算
	 * 如果+ - * / 后跟的是（，则将运算符和括号都入栈， 然后按规则1、2计算括号内部的数，直到遇见右括号
	 * 再依次出栈，将左括号之前的数都相加
	 * 再将左括号之前的运算符出栈，进行计算，如果是+ -，直接入栈正数或者负数
	 * 如果是* / 需要再出栈一位,计算乘除后的结果
	 *
	 * 优化点： 括号里的可以用递归
	 */
	public int calculate(String s) {
		Stack<String> stack = new Stack<>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if (i == 0 || s.charAt(i-1) == '(') {
					sb.append("+");
				}
			}
			sb.append(s.charAt(i));
		}

		s = sb.toString();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '+') {
				if (i + 1 < s.length()) {
					if (s.charAt(i+1) != '(') {
						stack.add(String.valueOf(getNum(s, i + 1)));
					} else {
						stack.add("+");
					}
				}
			} else if (s.charAt(i) == '-') {
				if (i + 1 < s.length()) {
					if (s.charAt(i+1) != '(') {
						stack.add("-" + String.valueOf(getNum(s, i + 1)));
					} else {
						stack.add("-");
					}
				}
			} else if (s.charAt(i) == '*') {
				if (i + 1 < s.length()) {
					if (s.charAt(i+1) != '(') {
						int num = getNum(s, i+1);
						int preNum = Integer.parseInt(stack.pop());
						stack.add(String.valueOf(num * preNum));
					} else {
						stack.add("*");
					}
				}
			} else if (s.charAt(i) == '/') {
				if (i + 1 < s.length()) {
					if (s.charAt(i+1) != '(') {
						int num = getNum(s, i+1);
						int preNum = Integer.parseInt(stack.pop());
						stack.add(String.valueOf(preNum / num));
					} else {
						stack.add("/");
					}
				}
			} else if (s.charAt(i) == '(') {
				stack.add("(");
			} else if (s.charAt(i) == ')') {
				int ps = 0;
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					int num = Integer.parseInt(stack.pop());
					ps = ps + num;
				}
				// 前一个括号'(' 出栈
				stack.pop();
				if (!stack.isEmpty()) {
					String ope = stack.peek();
					//左括号前的运算符 "（"出栈
					if (ope.equals("*")) {
						stack.pop();
						int preNum = Integer.parseInt(stack.pop());
						ps = preNum * ps;
					} else if (ope.equals("/")) {
						stack.pop();
						int preNum = Integer.parseInt(stack.pop());
						ps = preNum / ps;
					} else if (ope.equals("-")) {
						stack.pop();
						ps = -ps;
					} else if (ope.equals("+")) {
						stack.pop();
					}
				}
				stack.add(String.valueOf(ps));
			}
		}

		int res = 0;
		while (!stack.isEmpty()) {
			res += Integer.parseInt(stack.pop());
		}
		return res;
	}

	int getNum(String s, int j) {
		int num = 0;
		while (j < s.length()) {
			char c = s.charAt(j);
			if (c <= '9' && c >= '0') {
				num = num * 10 + (c - '0');
			} else {
				break;
			}
			j++;
		}
		return num;
	}
}
