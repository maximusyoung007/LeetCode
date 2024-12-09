package solution;

import java.util.Stack;

public class Solution0114 {
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();

		stack.add(root);

		TreeNode head = new TreeNode(-1);
		TreeNode t = head;

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();

			//node在读取之前就存起来了
			t.left = null;
			t.right = node;
			t = t.right;

			TreeNode left = node.left;
			TreeNode right = node.right;

			if (right != null) {
				stack.push(right);
			}

			if (left != null) {
				stack.push(left);
			}

			node.left = null;
		}

		root = head.right;
	}
}
