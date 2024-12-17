package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0399 {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, Map<String, Double>> graph = new HashMap<>();

		//建图
		for (int i = 0; i < equations.size(); i++) {
			String a = equations.get(i).get(0), b = equations.get(i).get(1);
			double val = values[i];
			if (!graph.containsKey(a)) {
				graph.put(a, new HashMap<>() {{put(b, val);}});
			} else {
				Map<String, Double> mapA = graph.get(a);
				mapA.put(b, val);
				graph.put(a, mapA);
			}
			if (!graph.containsKey(b)) {
				graph.put(b, new HashMap<>() {{put(a, 1/val);}});
			} else {
				Map<String, Double> mapB = graph.get(b);
				mapB.put(a, 1/val);
				graph.put(b, mapB);
			}
		}

		int size = queries.size();
		double[] res = new double[size];
		Arrays.fill(res, -1.0);
		for (int i = 0; i < size; i++) {
			String query1 = queries.get(i).get(0);
			String query2 = queries.get(i).get(1);

			if (!graph.containsKey(query1) || !graph.containsKey(query2)) {
				continue;
			}

			Map<String, Boolean> isVisited = new HashMap<>();

			dfs(graph, 1, query1, query2, isVisited, res, i);
		}

		return res;
	}

	public void dfs(Map<String, Map<String, Double>> graph,
					double curVal, String query1, String query2, Map<String, Boolean> isVisited, double[] res, int i) {

		isVisited.put(query1, true);

		if (graph.get(query1).containsKey(query2)) {
			res[i] = curVal * graph.get(query1).get(query2);
		}

		for (String key : graph.get(query1).keySet()) {
			if (isVisited.containsKey(key)) {
				continue;
			}

			dfs(graph, curVal * graph.get(query1).get(key), key, query2, isVisited, res, i);
		}

	}

}
