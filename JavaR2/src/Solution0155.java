import java.util.Stack;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/8/2      create
 */
public class Solution0155 {
	public void testMinStack() {
//		MinStack minStack = new MinStack();
//		minStack.push(-2);
//		minStack.push(0);
//		minStack.push(-3);
//		System.out.println(minStack.getMin());
//		minStack.pop();
//		minStack.pop();
//		System.out.println(minStack.getMin());

		//["MinStack","push","push","push","getMin","pop","getMin"]
		//[[],[0],[1],[0],[],[],[]]
		MinStack minStack = new MinStack();
		minStack.push(0);
		minStack.push(1);
		minStack.push(0);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
	}
}

class MinStack {
	Stack<Integer> in;

	//把所有最小的都存下来，如果最小的出栈了，可以找到下一个最小的
	Stack<Integer> minStack;

	public MinStack() {
		in = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int val) {
		in.push(val);
		if (minStack.isEmpty() || val <= minStack.peek()) {
			minStack.push(val);
		}
	}

	public void pop() {
		int t = in.pop();
		if (!minStack.isEmpty() && minStack.peek() == t) {
			minStack.pop();
		}
	}

	public int top() {
		return in.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
