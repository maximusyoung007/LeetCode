public class Solution0101 {
	public boolean isSymmetric(TreeNode root) {
		return symmetric(root.left, root.right);
	}

	public boolean symmetric(TreeNode left, TreeNode right) {
		//两个都是空节点，则表示递归到最底下了，表示之前的节点没有返回false的，则返回true
		if (left == null && right == null) {
			return true;
		}

		//只有左节点或者右节点为空，返回false
		if (left == null || right == null) {
			return false;
		}

		//两个值不相等，返回false
		if (left.val != right.val) {
			return false;
		}

		return symmetric(left.left, right.right) && symmetric(left.right, right.left);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
