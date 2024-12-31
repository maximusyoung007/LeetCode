package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution0373 {

	//优先队列，先把num2的最小值和nums1的值全部入队，然后依次出队，出队的nums1的值和nums2后续的值组成一个新的值入队，出一个，进一个
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

	}

	PriorityQueue<Integer[]> queue;
	boolean[][] visited;
	//优先队列超时
	public List<List<Integer>> kSmallestPairsFail(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> result = new ArrayList<>();
		visited = new boolean[nums1.length][nums2.length];
		queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] + a[1]));
		dfs(nums1, nums2, 0, 0, visited);
		for (int i = 0; i < k; i++) {
			List<Integer> t = Arrays.asList(queue.poll());
			result.add(t);
		}

		return result;
	}

	public void dfs(int[] nums1, int[] nums2, int i, int j, boolean[][] visited) {
		if (i > nums1.length - 1 || j > nums2.length - 1 || visited[i][j]) {
			return;
		}

		queue.add(new Integer[]{nums1[i], nums2[j]});
		visited[i][j] = true;

		dfs(nums1, nums2, i, j+1, visited);
		dfs(nums1, nums2, i+1, j, visited);
	}
}
