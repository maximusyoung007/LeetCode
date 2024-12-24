package solution;

public class Solution0108 {
	public TreeNode sortedArrayToBST(int[] nums) {
		int left = 0, right = nums.length - 1;
		return buildBST(nums, left, right);
	}

	public TreeNode buildBST(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;

		TreeNode node = new TreeNode(nums[mid]);
		node.left = buildBST(nums, left, mid - 1);
		node.right = buildBST(nums, mid+1, right);

		return node;
	}
}
