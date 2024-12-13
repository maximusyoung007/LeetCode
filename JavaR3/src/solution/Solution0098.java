package solution;

import java.util.Stack;

public class Solution0098 {
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return false;
		}
		Stack<TreeNode> stack = new Stack<>();

		stack.push(root);

		TreeNode cur = root;

		int pre = 0;
		boolean first = true;

		while (!stack.isEmpty()) {
			while (cur.left != null) {
				cur = cur.left;
				stack.push(cur);
			}

			TreeNode t = stack.pop();

			if (!first && t.val <= pre) {
				return false;
			}

			pre = t.val;
			first = false;

			if (t.right != null) {
				stack.push(t.right);
				cur = t.right;
			}
		}

		return true;
	}
}
