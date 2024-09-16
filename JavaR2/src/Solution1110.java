import java.util.ArrayList;
import java.util.List;

/**
 * 从上往下递归节点，如果当前节点为要删除的节点，则将当前节点的左右子节点加入结果list，当前节点本身置为null
 */
public class Solution1110 {

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<Integer> deleteList = new ArrayList<>();
		for (int de : to_delete) {
			deleteList.add(de);
		}
		List<TreeNode> res = new ArrayList<>();

		root = helper(root, res, deleteList);

		if (root != null) {
			res.add(root);
		}

		return res;
	}

	public TreeNode helper(TreeNode root, List<TreeNode> res, List<Integer> delList) {
		if (root == null) {
			return null;
		}

		root.left = helper(root.left, res, delList);
		root.right = helper(root.right, res, delList);

		if (delList.contains(root.val)) {
			if (root.left != null) {
				res.add(root.left);
			}

			if (root.right != null) {
				res.add(root.right);
			}

			root = null;
		}

		return root;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
