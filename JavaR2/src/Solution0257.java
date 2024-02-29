import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/29      create
 */
class TreeNode {
int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
public class Solution0257 {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		dfs(root, "", res);
		return res;
	}

	private void dfs(TreeNode root, String s, List<String> res) {
		if (root.left == null && root.right == null) {
			s = s + root.val;
			String t = s;
			res.add(t);
			return;
		}
		s = s + root.val + "->";

		if (root.left != null) {
			dfs(root.left, s, res);
		}
		if (root.right != null) {
			dfs(root.right, s, res);
		}
	}
}
