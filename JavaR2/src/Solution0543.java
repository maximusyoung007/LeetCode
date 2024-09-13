
public class Solution0543 {
	int res = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		getHeight(root);
		return res;
	}

	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		//对于root来说，最长的路径就是左子树-root-右子树
		if (leftHeight + rightHeight > res) {
			res = leftHeight + rightHeight;
		}

		return Integer.max(leftHeight, rightHeight) + 1;
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
