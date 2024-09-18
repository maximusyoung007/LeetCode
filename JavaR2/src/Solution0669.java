/**
 * @author maximusyoung
 */
public class Solution0669 {
	public TreeNode trimBST(TreeNode root, int low, int high) {
		return recursion(root, low, high);
	}

	public TreeNode recursion(TreeNode root, int low, int high) {
		if (root == null) {
			return null;
		}

		//小于low,则向右边更大的递归
		if (root.val < low) {
			return recursion(root.right, low, high);
		}

		//大于high同理
		if (root.val > high) {
			return recursion(root.left, low, high);
		}

		root.left = recursion(root.left, low, high);
		root.right = recursion(root.right, low, high);

		return root;
	}
}
