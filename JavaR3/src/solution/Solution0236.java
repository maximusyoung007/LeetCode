package solution;

public class Solution0236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return dfs(root, p, q);
	}

	public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
		if (node == null) {
			return null;
		}
		if (find(node, p) && find(node, q)) {
			return node;
		}

		TreeNode left = dfs(node.left, p, q);
		TreeNode right = dfs(node.right, p, q);
		return left != null ? left : right;
	}

	public TreeNode find(TreeNode node, TreeNode target) {
		if (node == null) {
			return null;
		}

		if (node.val == target.val) {
			return node;
		}



		return find(node.left, target) || find(node.right, target);
	}
}
