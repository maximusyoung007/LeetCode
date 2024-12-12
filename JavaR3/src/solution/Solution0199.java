package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution0199 {
	public List<Integer> rightSideView(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}

		List<Integer> res = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		int k = 1;
		queue.add(root);

		while (!queue.isEmpty()) {
			int tk = 0;
			for (int i = 0; i < k; i++) {
				TreeNode t = queue.poll();
				if (i == k - 1) {
					res.add(t.val);
				}

				if (t.left != null) {
					queue.add(t.left);
					tk++;
				}

				if (t.right != null) {
					queue.add(t.right);
					tk++;
				}
			}
			k = tk;
		}

		return res;
	}
}
