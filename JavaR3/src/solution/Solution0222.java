package solution;

public class Solution0222 {
	/**
	 * 计算左右子树的高度
	 * 如果left == right, 则左子树一定是一个完全二叉树，节点数为2^left-1，再递归计算右子树节点数
	 * 如果left != right, 则右子树到倒数第二层是一个完全二叉树，节点数为2^right-1，再递归计算左子树节点数
	 * @param root
	 * @return
	 */
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = calHeight(root.left);
		int rightHeight = calHeight(root.right);

		int countLeft = 0, countRight = 0;
		if (leftHeight == rightHeight) {
			countLeft = (1<<leftHeight) - 1;

			countRight = countNodes(root.right);
		} else {
			countRight = (1<<rightHeight) - 1;

			countLeft = countNodes(root.left);
		}

		return countLeft + countRight + 1;
	}

	public int calHeight(TreeNode node) {
		int height = 0;

		while (node != null) {
			height++;
			node = node.left;
		}

		return height;
	}
}
