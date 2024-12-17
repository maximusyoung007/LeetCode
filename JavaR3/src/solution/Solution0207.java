package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution0207 {
	//判断图中是否有环 拓扑排序
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites.length == 0) {
			return true;
		}
		int[] in = new int[numCourses];
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int[] prerequisite : prerequisites) {
			int p1 = prerequisite[0];
			int p2 = prerequisite[1];

			if (!graph.containsKey(p1)) {
				graph.put(p1, new ArrayList<>() {{add(p2);}});
			} else {
				List<Integer> t = graph.get(p1);
				t.add(p2);
				graph.put(p1, t);
			}

			in[p2]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		//入度为0的节点入队
		for (int i = 0; i < in.length; i++) {
			if (in[i] == 0) {
				queue.add(i);
			}
		}

		List<Integer> topoLogical = new ArrayList<>();
		while (!queue.isEmpty()) {
			int t = queue.poll();
			topoLogical.add(t);

			List<Integer> tl = graph.get(t);
			if (tl != null && !tl.isEmpty()) {
				for (Integer next : tl) {
					in[next]--;
					if (in[next] == 0) {
						queue.add(next);
					}
				}
			}

		}

        return topoLogical.size() == numCourses;
    }

}
