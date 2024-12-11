package solution;

public class Solution0124 {

	int maxValue;

	public int maxPathSum(TreeNode root) {
		// 以node为根节点的最大值，有可能是
		//1. node.val 2. node.val + 左侧最大值 3 node.val + 右侧最大值 4 node.val + 左侧最大值 + 右侧最大值
		//向上递归的路径不能同时包含左右两侧路径，因此只可能是1，2，3其中最大值
		//叶子节点最大值和向上递归的值就是其自身
		maxValue = Integer.MIN_VALUE;
		dfs(root);
		return maxValue;
	}

	public int dfs(TreeNode node) {
		int nodeMaxValue = 0;
		int nodeReturnValue = 0;
		if (node.left == null && node.right == null) {
			nodeMaxValue = node.val;
			nodeReturnValue = node.val;
		} else {
			int leftVal = 0, rightVal = 0;
			if (node.left != null) {
				leftVal = dfs(node.left);
			}

			if (node.right != null) {
				rightVal = dfs(node.right);
			}

			nodeReturnValue =
				Integer.max(
					Integer.max(node.val, node.val + leftVal), node.val + rightVal);

			nodeMaxValue = Integer.max(nodeReturnValue, node.val + leftVal + rightVal);
		}

		if (nodeMaxValue > maxValue) {
			maxValue = nodeMaxValue;
		}

		return nodeReturnValue;
 	}
}
