import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/3/1      create
 */
public class Solution0310 {
	//n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
	//n = 4, edges = [[1,0],[1,2],[1,3]]
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		Map<Integer, List<Integer>> m = new HashMap<>();
		for (int[] edge : edges) {
			List<Integer> l = m.getOrDefault(edge[0], new ArrayList<>());
			l.add(edge[1]);
			m.put(edge[0], l);

			List<Integer> l2 = m.getOrDefault(edge[1], new ArrayList<>());
			l2.add(edge[0]);
			m.put(edge[1], l2);
		}
		int height = Integer.MAX_VALUE;
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			boolean[] visited = new boolean[n];
			int h = bfs(i, n, m, visited);
			if (h < height) {
				res.clear();
				res.add(i);
				height = h;
			} else if (h == height) {
				res.add(i);
			}
		}

		return res;
	}

	private int bfs(int i,int n, Map<Integer, List<Integer>> m, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		visited[i] = true;
		int h = 0;
		int total = 1;
		while (!queue.isEmpty()) {
			int count = queue.size();
			h++;
			for (int j = 0; j < count; j++) {
				int top = queue.poll();
				List<Integer> tl = m.get(top);
				for (int k = 0; k < tl.size(); k++) {
					if (!visited[tl.get(k)]) {
						queue.add(tl.get(k));
					}
					visited[tl.get(k)] = true;
				}
			}
			total += queue.size();
			if (total == n) {
				return h;
			}
		}
		return 0;
	}
}
