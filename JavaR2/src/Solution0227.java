import java.util.Stack;

/**
 * 3+5/2
 * +，-看作是数字的一部分，一起入栈
 * 遇到*，/则将上一个数字出栈，然后计算结果后入栈
 * 最后栈里还有剩余的数依次出栈
 */
public class Solution0227 {
	public int calculate(String s) {
		s = "+" + s.replaceAll(" ", "");
		Stack<Integer> stack = new Stack();

		int num, t, res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '+') {
				stack.add(getNum(i+1, s));
			} else if (c == '-') {
				stack.add(-getNum(i+1, s));
			} else if (c == '*') {
				num = stack.pop();
				t = num * (getNum(i+1, s));
				stack.add(t);
			} else if (c == '/') {
				num = stack.pop();
				t = num / (getNum(i+1, s));
				stack.add(t);
			}
		}

		while (!stack.isEmpty()) {
			num = stack.pop();
			res += num;
		}

		return res;
	}

	private int getNum(int i, String s) {
		int num = 0;
		while (i < s.length() && s.charAt(i) <= '9' && s.charAt(i) >= '0') {
			num = num * 10 + (s.charAt(i) - '0');
			i++;
		}
		return num;
	}
}
