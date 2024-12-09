package solution;

public class Solution0106 {
	//中序 后序
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		TreeNode res;
		if (postorder.length == 1) {
			res = new TreeNode(postorder[0]);
		} else if (postorder.length == 0) {
			res = null;
		} else if (postorder.length == 2) {
			res = new TreeNode(postorder[1]);
			if (postorder[1] == inorder[0]) {
				res.left = null;
				res.right = new TreeNode(inorder[1]);
			} else {
				res.left = new TreeNode(inorder[0]);
				res.right = null;
			}
		} else {
			int postVal = postorder[postorder.length - 1];
			res = new TreeNode(postVal);
			int index = 0;
			for (int i = 0; i < inorder.length; i++) {
				if (inorder[i] == postVal) {
					index = i;
				}
			}

			int[] inOrderLeft = new int[index];
			int[] postOrderLeft = new int[index];

			System.arraycopy(inorder, 0, inOrderLeft, 0, index);
			System.arraycopy(postorder, 0, postOrderLeft, 0, index);

			int[] inorderRight = new int[inorder.length - index - 1];
			int[] postorderRight = new int[postorder.length - index - 1];

			System.arraycopy(inorder, index + 1, inorderRight, 0, inorder.length - index - 1);
			System.arraycopy(postorder, index, postorderRight, 0, postorder.length - index - 1);

			res.left = buildTree(inOrderLeft, postOrderLeft);
			res.right = buildTree(inorderRight, postorderRight);
		}

		return res;
	}
}
