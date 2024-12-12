package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution0637 {
	public List<Double> averageOfLevels(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}

		List<Double> result = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();

		int k = 1;
		queue.add(root);

		while (!queue.isEmpty()) {
			int tk = 0;
			long sum = 0;
			for (int i = 0; i < k; i++) {
				TreeNode t = queue.poll();
				sum += t.val;

				if (t.left != null) {
					queue.add(t.left);
					tk++;
				}

				if (t.right != null) {
					queue.add(t.right);
					tk++;
				}
			}
			result.add((double) sum / (double) k);
			k = tk;
		}

		return result;
	}
}
