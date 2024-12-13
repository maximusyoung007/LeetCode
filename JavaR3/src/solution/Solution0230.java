package solution;

import java.util.Stack;

public class Solution0230 {
	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return 0;
		}
		Stack<TreeNode> stack = new Stack<>();

		stack.push(root);

		int count = 0;

		TreeNode cur = root;

		while (!stack.isEmpty()) {
			while (cur.left != null) {
				cur = cur.left;
				stack.push(cur);
			}

			TreeNode t = stack.pop();
			count++;
			if (count == k) {
				return t.val;
			}

			if (t.right != null) {
				stack.push(t.right);
				cur = t.right;
			}
		}

		return 0;
	}
}
