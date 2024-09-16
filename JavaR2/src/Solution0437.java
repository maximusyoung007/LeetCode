public class Solution0437 {
	public int pathSum(TreeNode root, int targetSum) {
		int res = rootNum(root, targetSum);
		if (root != null) {
			res += pathSum(root.left, targetSum);
			res += pathSum(root.right, targetSum);
		}
		return res;
	}

	public int rootNum(TreeNode root, long targetSum) {
		int ret = 0;
		if (root == null) {
			return 0;
		}

		long t = root.val;
		if (t == targetSum) {
			ret++;
		}

		ret += rootNum(root.left, targetSum - t);
		ret += rootNum(root.right, targetSum - t);

		return ret;
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
