import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/10/12      create
 */
public class Solution1059 {

	/**
	 * 深度优先遍历
	 * 如果走到一个节点，它不等于destination，并且无法再往下走了，则返回false
	 * 如果走到了destination，则向上回溯；
	 * 如果图中有环，也直接返回false
	 * @return
	 */
	public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
		List<Integer>[] graph = new List[n];

		Set<Integer> path = new HashSet<>();

		//使用can存储哪些节点可以走到destination，如果可以往下走，就直接返回true，不用再往下走了
		boolean[] can = new boolean[n];

		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int[] edge : edges) {
			graph[edge[0]].add(edge[1]);
		}

		//path表示当前路径中有哪些节点，排除图中有环的情况
		path.add(source);

		return dfs(graph, source, destination, path, can);
	}

	private boolean dfs(List<Integer>[] list, int source, int destination, Set<Integer> path, boolean[] can) {
		if (can[source]) {
			return true;
		}

		List<Integer> l = list[source];

		if (l == null || l.isEmpty()) {
			if (source == destination) {

				return true;
			} else {
				return false;
			}
		}

		for (Integer point : l) {
			//如果路径中出现重复的数，就表示进环了，直接返回false
			if (path.contains(point)) {
				return false;
			}
			path.add(point);
			if (!dfs(list, point, destination, path, can)) {
				return false;
			}
			can[point] = true;
			path.remove(point);
		}
		return true;
	}
}
