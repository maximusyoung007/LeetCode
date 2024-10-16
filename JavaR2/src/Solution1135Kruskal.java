import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author maximusyoung
 */
public class Solution1135Kruskal {
	int[] p;
	public int minimumCost(int n, int[][] connections) {
		int minCost = 0;

		//用来存储已经选中的边的数量
		int edgeCount = 0;
		//优先队列根据边的长度排序
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

		for (int[] c : connections) {
			queue.add(c);
		}

		//使用并查集判断点是否已经被选过了
		p = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			p[i] = i;
		}

		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			int fa = find(point[0]);
			int fb = find(point[1]);

			//这条边已经在图里了
			if (fa == fb) {
				continue;
			}

			minCost += point[2];
			edgeCount++;

			p[fa] = fb;
		}

		return edgeCount == n - 1 ? minCost : -1;

	}

	private int find(int x) {
		if (p[x] == x) {
			return x;
		} else {
			//路径压缩，首次压缩后，下次再查找这个路径上的点，就可以直接找到父节点
			p[x] = find(p[x]);
			return p[x];
		}
	}
}
