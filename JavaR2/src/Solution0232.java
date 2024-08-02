import java.util.Stack;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/8/2      create
 */
public class Solution0232 {
	public void testQueue() {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		System.out.println(queue.peek());
		System.out.println(queue.pop());
		System.out.println(queue.empty());
	}
}
class MyQueue {
	Stack<Integer> in;
	Stack<Integer> out;

	public MyQueue() {
		in = new Stack<>();
		out = new Stack<>();
	}

	public void push(int x) {
		in.push(x);
	}

	public int pop() {
		if (!out.isEmpty()) {
			return out.pop();
		} else {
			while (!in.isEmpty()) {
				int t = in.pop();
				out.push(t);
			}
			return out.pop();
		}
	}

	public int peek() {
		if (!out.isEmpty()) {
			return out.peek();
		} else {
			while (!in.isEmpty()) {
				int t = in.pop();
				out.push(t);
			}
			return out.peek();
		}
	}

	public boolean empty() {
		return in.isEmpty() && out.isEmpty();
	}
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */