/**
 * @author maximusyoung
 */
public class Solution0538 {
	public TreeNode convertBST(TreeNode root) {
		recursion(root, 0, false);
		return root;
	}


	public int recursion(TreeNode root, int parent, boolean isLeft) {
		if (root == null) {
			return 0;
		}

		int res = root.val + parent;

		if (root.right != null) {
			res += recursion(root.right, 0, false);
		}

		root.val = res;

		int t = 0;
		if (root.left != null) {
			t = recursion(root.left, res, true);
		}

		if (!isLeft) {
			return res;
		}
		return t;
	}
}
