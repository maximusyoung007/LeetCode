package solution;

public class Solution0104 {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		//叶子节点，高度为1
		if (null == root.left && null == root.right) {
			return 1;
		}

		//递归
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
