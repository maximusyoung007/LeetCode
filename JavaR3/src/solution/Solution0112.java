package solution;

public class Solution0112 {
	public boolean hasPathSum(TreeNode root, int targetSum) {
		return dfs(root, 0, targetSum);
	}

	public boolean dfs(TreeNode node, int sum, int targetSum) {
		if (node == null) {
			return false;
		}
		sum += node.val;
		if (sum == targetSum && node.left == null && node.right == null) {
			return true;
		}


		return dfs(node.left, sum, targetSum) || dfs(node.right, sum, targetSum);

	}
}
