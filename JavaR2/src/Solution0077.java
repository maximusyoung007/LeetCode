import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/28      create
 */
public class Solution0077 {
	public List<List<Integer>> combine(int n, int k) {
		List<Integer> pr = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		boolean[] isVisited = new boolean[n+1];
		dfs(n, k, 0, isVisited, pr, res);
		return res;
	}

	private void dfs(int n, int k, int oldIndex,  boolean[] isVisited, List<Integer> pr, List<List<Integer>> res) {

		//从上一层遍历的后一位开始遍历
		for (int i = oldIndex + 1; i <= n; i++) {
			if (isVisited[i]) {
				continue;
			}

			pr.add(i);
			isVisited[i] = true;

			if (pr.size() == k) {
				List<Integer> t = new ArrayList<>();
				t.addAll(pr);
				res.add(t);
			}

			dfs(n, k, i, isVisited, pr, res);

			//剪枝
			pr.remove(pr.size() - 1);
			isVisited[i] = false;

		}
	}
}
