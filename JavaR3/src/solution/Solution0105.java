package solution;

public class Solution0105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 3) {
			TreeNode node = new TreeNode(preorder[0]);
			node.left = new TreeNode(preorder[1]);
			node.right = new TreeNode(preorder[2]);

			return node;
		} else if (preorder.length == 2) {
			TreeNode node = new TreeNode(preorder[0]);

			if (preorder[1] == inorder[1]) {
				node.left = null;
				node.right = new TreeNode(preorder[1]);
			} else {
				node.left = new TreeNode(inorder[0]);
				node.right = null;
			}
		} else if (preorder.length == 1) {
			return new TreeNode(preorder[0]);
		} else {
			
		}
	}
}
