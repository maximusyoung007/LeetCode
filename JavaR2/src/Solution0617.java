/**
 * @author maximusyoung
 */
public class Solution0617 {
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		TreeNode root = new TreeNode();
		return recursion(root, root1, root2);
	}

	public TreeNode recursion(TreeNode root, TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return null;
		}

		TreeNode left1 = null, left2 = null, right1 = null, right2 = null;
		
		if (root1 == null) {
			root = root2;
			left1 = null;
			right1 = null;
			left2 = root2.left;
			right2 = root2.right;
		}

		if (root2 == null) {
			root = root1;
			left1 = root1.left;
			right1 = root1.right;
			left2 = null;
			right2 = null;
		}

		if (root1 != null && root2 != null) {
			root = new TreeNode(root1.val + root2.val);
			left1 = root1.left;
			right1 = root1.right;
			left2 = root2.left;
			right2 = root2.right;
		}
		

		root.left = recursion(root.left, left1, left2);
		root.right = recursion(root.right, right1, right2);

		return root;
	}
}
