package solution;

public class Solution0129 {
	int sum = 0;
	public int sumNumbers(TreeNode root) {
		int num = 0;
		dfs(root, num);
		return sum;
	}

	public void dfs(TreeNode node, int num) {
		if (node == null) {
			return;
		}

		num = num * 10 + node.val;

		//到叶子节点了就计算结果并返回
		if (node.left == null && node.right == null) {
			sum += num;
			return;
		}

		//否则继续往下递归
		dfs(node.left, num);
		dfs(node.right, num);
	}
}
