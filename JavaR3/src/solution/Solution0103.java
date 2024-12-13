package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution0103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}

		List<List<Integer>> result = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();

		int order = 1;
		int k = 1;
		queue.add(root);

		while (!queue.isEmpty()) {
			int tk = 0;

			List<Integer> ps = new ArrayList<>();
			for (int i = 0; i < k; i++) {
				TreeNode t = queue.poll();

				ps.add(t.val);

				if (t.left != null) {
					queue.add(t.left);
					tk++;
				}

				if (t.right != null) {
					queue.add(t.right);
					tk++;
				}
			}

			if (order == -1) {
				Collections.reverse(ps);
			}
			result.add(ps);
			order *= -1;
			k = tk;
		}

		return result;
	}
}
