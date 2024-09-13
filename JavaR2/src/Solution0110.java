
public class Solution0110 {
	public boolean isBalanced(TreeNode root) {
		//如果不等于-1，则表示是二叉平衡树
		return getHeight(root) != -1;
	}

	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		//如果左子树或者右子树为-1，则返回-1
		if (getHeight(root.left) == -1 || getHeight(root.right) == -1) {
			return -1;
		}

		//如果左右子树高度不满足二叉平衡树，则返回-1
		int sub = getHeight(root.left) - getHeight(root.right);
		if (sub > 1 || sub < -1) {
			return -1;
		}

		return Integer.max(getHeight(root.left), getHeight(root.right)) + 1;

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
