import java.util.Stack;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/8/2      create
 */
public class Solution0739 {
	/**
	 * [73,74,75,71,69,72,76,73]
	 *
	 * [89,62,70,58,47,47,46,76,100,70]
	 * [8,1,5,4,3,2,1,1,0,0]
	 * @param temperatures
	 * @return
	 * 使用单调递减栈
	 * 栈中存放的是数组下标
	 *
	 * 数组中元素依次入栈
	 * 如果是空栈，或者当前入栈元素小于或等于栈顶元素，则入栈
	 * 如果不是空栈，且当前入栈元素大于栈顶元素，则判断当前入栈元素的位置和栈顶元素位置的差值，其差值就表示栈顶元素到下一个温度更高日期的天数
	 * 栈顶元素出栈，当前元素入栈
	 */
	public int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		int[] res = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
//			if (stack.isEmpty()) {
//				stack.push(i);
//			} else {
//				if (temperatures[i] <= temperatures[stack.peek()]) {
//					stack.push(i);
//				} else {
//					while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
//						int pi = stack.pop();
//						res[pi] = i - pi;
//					}
//					stack.push(i);
//
//				}
//			}

			//可以把三个 stack.push(i)合并到一个
			//如果想更快，可以用linkedList（Deque）或者数组模拟栈
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int pi = stack.pop();
				res[pi] = i - pi;
			}
			stack.push(i);

		}
		return res;
	}
}
