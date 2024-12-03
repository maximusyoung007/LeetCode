package solution;

public class Solution0101 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (root.left == null && root.right == null) {
			return true;
		}

		if (root.left != null && root.right == null) {
			return false;
		}

		if (root.left == null) {
			return false;
		}

		if (root.left.val != root.right.val) {
			return false;
		}

		return symmetric(root.left, root.right);
	}

	public boolean symmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null) {
			return false;
		}

		if (right == null) {
			return false;
		}

		if (left.val != right.val) {
			return false;
		}

		return symmetric(left.left, right.right) && symmetric(left.right, right.left);

	}
}
