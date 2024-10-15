import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author maximusyoung
 */
public class Solution1135Kruskal {
	public int minimumCost(int n, int[][] connections) {
		//优先队列根据边的长度排序
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[3]));

		for (int[] c : connections) {
			queue.add(c);
		}

		//使用并查集判断点是否已经被选中了
		int[] p = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			p[i] = i;
		}



	}
}
