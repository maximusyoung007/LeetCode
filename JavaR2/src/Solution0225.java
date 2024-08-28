import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/8/22      create
 */
public class Solution0225 {
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		System.out.println(myStack.top());
		System.out.println(myStack.pop());
		System.out.println(myStack.top());
	}
}

class MyStack {
	/**
	 *  一个队列，获取队列实现
	 *  出栈时，除了最后一个元素，其他元素全都先出队，再入队，此时队首元素即为出栈元素
	 *  获取栈顶元素同理，获取后，将队首元素重新入队
	 */
	Queue<Integer> queue;

	public MyStack() {
		queue = new LinkedList<>();
	}

	public void push(int x) {
		queue.add(x);
	}

	public int pop() {
		int size = queue.size();
		while (size-- > 1) {
			int t = queue.poll();
			queue.add(t);
		}
		return queue.poll();
	}

	public int top() {
		int size = queue.size();
		while (size-- > 1) {
			int t = queue.poll();
			queue.add(t);
		}
		int res = queue.poll();
		queue.add(res);
		return res;
	}

	public boolean empty() {
		return queue.isEmpty();
	}
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
