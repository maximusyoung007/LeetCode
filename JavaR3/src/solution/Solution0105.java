package solution;

public class Solution0105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode node;
		if (preorder.length == 2) {
			node = new TreeNode(preorder[0]);

			if (preorder[1] == inorder[1]) {
				node.left = null;
				node.right = new TreeNode(preorder[1]);
			} else {
				node.left = new TreeNode(inorder[0]);
				node.right = null;
			}
		} else if (preorder.length == 1) {
			node = new TreeNode(preorder[0]);
		} else if (preorder.length == 0) {
			return null;
		} else {
			int preValue = preorder[0];
			node = new TreeNode(preValue);
			int index = 0;
			for (int i = 0; i < inorder.length; i++) {
				if (inorder[i] == preValue) {
					index = i;
					break;
				}
			}

			int[] preOrder0 = new int[index];
			int[] inOrder0 = new int[index];

			//[3,9,20,15,7], inorder = [9,3,15,20,7]
			System.arraycopy(preorder, 1, preOrder0, 0, index);
			System.arraycopy(inorder, 0, inOrder0, 0, index);

			int[] preOrder1 = new int[preorder.length - index - 1];
			int[] inOrder1 = new int[preorder.length - index - 1];

			System.arraycopy(preorder, index+1, preOrder1, 0, preorder.length - index - 1);
			System.arraycopy(inorder, index+1, inOrder1, 0, preorder.length - index - 1);

			node.left = buildTree(preOrder0, inOrder0);
			node.right = buildTree(preOrder1, inOrder1);
		}

		return node;
	}
}
