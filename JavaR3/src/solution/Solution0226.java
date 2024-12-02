package solution;

public class Solution0226 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.left != null && root.right != null) {
			TreeNode t = root.right;
			root.right = root.left;
			root.left = t;
		} else if (root.left != null && root.right == null) {
			root.right = root.left;
			root.left = null;
		} else if (root.right != null && root.left == null) {
			root.left = root.right;
			root.right = null;
		}

		if (root.left != null) {
			invertTree(root.left);
		}

		if (root.right != null) {
			invertTree(root.right);
		}

		return root;
	}
}
