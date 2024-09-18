/**
 * @author maximusyoung
 */
public class Solution0572 {
	TreeNode t = null;
	boolean res = false;
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		find(root, subRoot);
		if (t == null) {
			return false;
		}
		return compare(t, subRoot);
	}

	public void find(TreeNode root, TreeNode subRoot) {
		if (root == null) {
			return;
		}
		if (root.val == subRoot.val) {
			t = root;
		}

		//找到和subRoot相同的节点，从这个节点开始判断是否是子树
		if (t != null && compare(t, subRoot)) {
			res = true;
			return;
		}

		if (root != null) {
			find(root.left, subRoot);
		}

		//如果是子树，就不再遍历右子树，因为有可能把原来为true的结果覆盖为false
		if (!res && root != null) {
			find(root.right, subRoot);
		}

	}

	public boolean compare(TreeNode root, TreeNode subRoot) {
		if (root == null && subRoot == null) {
			return true;
		}

		if (root == null || subRoot == null) {
			return false;
		}
		if (root.val != subRoot.val) {
			return false;
		}

		boolean res1 = compare(root.left, subRoot.left);
		boolean res2 = compare(root.right, subRoot.right);

		return res1 && res2;
	}
}
