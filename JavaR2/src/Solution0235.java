/**
 * @author maximusyoung
 */
public class Solution0235 {
	TreeNode res;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		recursion(root, p, q);
		return res;
	}

	public void recursion(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return;
		}

		//当前值等于p或者q,则p或q本身就是最大节点
		if (root.val == p.val || root.val == q.val) {
			res = root;
			return;
		}

		//都大于root,就向右递归；都小于root，就向左递归；一大一小，当前节点就是最近公共祖先
		if (p.val > root.val && q.val > root.val) {
			recursion(root.right, p, q);
		} else if (p.val < root.val && q.val < root.val) {
			recursion(root.left, p, q);
		} else {
			res = root;
			return;
		}

	}
}
