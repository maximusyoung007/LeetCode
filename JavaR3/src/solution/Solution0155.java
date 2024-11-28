package solution;

import java.util.Objects;
import java.util.Stack;

public class Solution0155 {
	//维护一个单调栈，用来保存最小值，栈顶一定是最小的
	static class MinStack {

		Stack<Integer> stack;
		Stack<Integer> minS;

		public MinStack() {
			stack = new Stack<>();
			minS = new Stack<>();
		}

		public void push(int val) {
			stack.push(val);
			if (minS.empty()) {
				minS.push(val);
			} else {
				if (val <= minS.peek()) {
					minS.push(val);
				}
			}
		}

		public void pop() {

			//最小值出栈
			if (!minS.isEmpty() && Objects.equals(stack.peek(), minS.peek())) {
				minS.pop();
			}
			stack.pop();

		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return minS.peek();
		}
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(512);
		minStack.push(-1024);
		minStack.push(-1024);
		minStack.push(512);
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());

	}
}
