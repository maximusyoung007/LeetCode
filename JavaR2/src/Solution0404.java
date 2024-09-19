/**
 * @author maximusyoung
 */
public class Solution0404 {
	int res = 0;
	public int sumOfLeftLeaves(TreeNode root) {
		cal(root, false);
		return res;
	}

	public void cal(TreeNode root, boolean isLeft) {
		if (root == null) {
			return;
		}

		if (isLeft && root.left == null && root.right == null) {
			res += root.val;
		}

		cal(root.left, true);
		cal(root.right, false);

	}
}
