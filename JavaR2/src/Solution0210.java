import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/10/12      create
 */
public class Solution0210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		//存储每个节点出发可以到达得节点
		List<ArrayList<Integer>> edges = IntStream.range(0, numCourses)
			.mapToObj(i -> new ArrayList<Integer>())
			.collect(Collectors.toList());

		//存储每个节点得入度
		int[] in = new int[numCourses];
		List<Integer> res = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();

		//prerequisite[1]是prerequisite[0]的前置节点
		for (int[] prerequisite : prerequisites) {
			List<Integer> points = edges.get(prerequisite[1]);
			if (points == null) {
				points = new ArrayList<>();
			}
			points.add(prerequisite[0]);
			in[prerequisite[0]]++;
		}

		for (int i = 0; i < numCourses; i++) {
			//入度为0，入队
			if (in[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int t = queue.poll();
			res.add(t);
			for (Integer i : edges.get(t)) {
				in[i]--;
				if (in[i] == 0) {
					queue.add(i);
				}
			}
		}

		if (res.size() == numCourses) {
			return res.stream().mapToInt(Integer::intValue).toArray();
		} else {
			return new int[0];
		}
	}
}
