/**
 * @author maximusyoung
 */
public class Solution0226 {
	public TreeNode invertTree(TreeNode root) {
		return recursion(root);
	}

	public TreeNode recursion(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode t = root.left;
		root.left = recursion(root.right);
		root.right = recursion(t);

		return root;

	}
}
