import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/8/5      create
 *
 * (1,3,-1,-3,5,3,6,7)
 * 3 3 5 5 6 7
 * 创建一个双端队列，用来存储滑动窗口的值
 * 遍历数组
 * 从尾部插入，如果尾部元素小于当前的元素，则将尾部元素出队
 * 这样可以保证双端队列的元素是从头到尾依次递减的，头部元素一定是最大的
 * 窗口继续向右滑动，如果头部元素不在窗口中了，从双端队列的头部出队
 */
public class Solution0239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		List<Integer> l = new ArrayList<>();
		Deque<Integer> queue = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {

			//如果第一个元素不在滑动窗口中了，且还在双端队列中，出队，
			// 如i=3,此时出队的应该是i=0, i=4,出队的是i=1，以此类推
			while (!queue.isEmpty() && queue.peekFirst() == i - k) {
				queue.pollFirst();
			}

			//如果队尾小于要插入的，队尾出队
			while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
				queue.pollLast();
			}
			//当前元素入队
			queue.addLast(i);


			//i到达k-1后，即满足了一个滑动窗口，后续的每一次循环，都会得到一个新的滑动窗口
			// 将这个新的滑动窗口的最大值加入到结果list中
			if (i >= k - 1) {
				l.add(nums[queue.peekFirst()]);
			}
		}

		return l.stream().mapToInt(Integer::intValue).toArray();

	}
}
