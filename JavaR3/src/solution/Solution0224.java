package solution;

import java.util.Stack;

public class Solution0224 {
	public int calculate(String s) {
		//中缀转后缀
		//如果数字，直接输出
		//如果优先级比栈顶更高 则不输出、入栈
		//如果是右括号，优先级比栈顶小，则依次出栈并输出，直到没有元素或者遇到左括号，并将当前元素入栈
		//如果是左括号，入栈
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

		}

		return 0;
	}
}
