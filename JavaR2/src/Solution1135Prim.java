import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * prim算法，依次选中权重最小的边所连接的点
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/10/15      create
 */
public class Solution1135Prim {
	public int minimumCost(int n, int[][] connections) {
		int minCost = 0;
		PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

		//用来存储已经选中的节点
		Set<Integer> chosen = new HashSet<>();

		List<Integer[]>[] graph = new List[n+1];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int[] connection : connections) {
			graph[connection[0]].add(new Integer[]{connection[1], connection[2]});
			graph[connection[1]].add(new Integer[]{connection[0], connection[2]});
		}

		chosen.add(1);
		List<Integer[]> list = graph[1];
		list.stream().forEach(l ->priorityQueue.add(l));

		while (chosen.size() != n && priorityQueue.size() > 0) {
			Integer[] min = priorityQueue.poll();

			//如果是已经选取的点，跳过
			if (chosen.contains(min[0])) {
				continue;
			}

			chosen.add(min[0]);
			minCost += min[1];

			List<Integer[]> list1 = graph[min[0]];
			//不在set里的，加到优先队列里
			list1.stream().filter(l -> !chosen.contains(l[0])).forEach(l -> priorityQueue.add(l));
		}

		return chosen.size() != n ? -1 : minCost;
	}
}
