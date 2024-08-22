import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/8/22      create
 */
public class Solution0503 {
	public int[] nextGreaterElements(int[] nums) {
		Stack<Integer> stack = new Stack<>();

		int n = nums.length;
		int[] res = new int[n];
		// 如果入栈的比当前元素小，则直接入栈
		// 否则，先计算差值，再入栈
		// 最后剩余在栈中的，就是后面没有更大的，但是可能在前面有更大的，所以开始后续循环
		// 后续循环中，可以从位置0循环到最大值所在位置，不需要重复入栈
		// 最后只有一个最大值会留在栈里
		// 栈中存的是下标
		stack.push(0);

		int i = 1;
		int end = n;
		int max = nums[0], maxIndex = 0;
		while (i < end) {
			if (nums[i] > max) {
				max = nums[i];
				maxIndex = i;
			}
			while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
				int t = stack.pop();
				res[t] = nums[i];
			}
			stack.push(i);
			i++;
		}

		//i初始化为0
		i = 0;
		while (i <= maxIndex && !stack.isEmpty()) {

			//如果等于最大值，则找不到比它大的，赋值 -1
			if (nums[stack.peek()] == max) {
				int t = stack.pop();
				res[t] = -1;
			}

			// 循环找比它大的
			while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
				int t = stack.pop();
				res[t] = nums[i];
			}

			//stack.push(i);
			i++;
			if (i > maxIndex) {
				i = 0;
			}
		}

		return res;
	}
}
