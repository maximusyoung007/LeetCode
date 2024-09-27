/**
 * @author maximusyoung
 */
public class Solution0538 {
	int t = 0;
	public TreeNode convertBST(TreeNode root) {
		recursion(root);
		return root;
	}

	public void recursion(TreeNode root) {
		if (root == null) {
			return;
		}

		recursion(root.right);

		t += root.val;
		root.val = t;

		recursion(root.left);

	}
}
