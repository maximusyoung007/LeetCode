package solution;

public class Solution0236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		/**
		 * node是最近公共祖先有3种情况
		 * 1、p，q分别位于root 左右两侧
		 * 2、p=root, q位于root左子树或右子树
		 * 3、q=root, p位于root左子树或右子树
		 */

		if (root == null) {
			return null;
		} else {

			if (root.val == p.val || root.val == q.val) {
				return root;
			}

			TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
			TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

			//leftNode和rightNode都为空，则没有找到
			if (leftNode == null && rightNode == null) {
				return null;
			}

			//p,q分别位于root两侧
			if (leftNode != null && rightNode != null) {
				return root;
			}

			//leftNode和rightNode其中一个为空，那么p,q都在左或者右子树,那么最近公共祖先就是子树的第一个节点
			if (leftNode != null) {
				return leftNode;
			}
            return rightNode;
        }

	}

}
