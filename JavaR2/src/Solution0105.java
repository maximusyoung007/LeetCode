public class Solution0105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, inorder);
	}

	public TreeNode build(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		//如果前序遍历有三个或者少于三个，可以直接组成一个子树
		if (preorder.length < 3) {
			TreeNode t = new TreeNode(preorder[0]);
			if (preorder.length == 2) {
				TreeNode left = new TreeNode(preorder[1]);
				t.left = left;
			}
			if (preorder.length == 3) {
				TreeNode right = new TreeNode(preorder[2]);
				t.right = right;
			}
			return t;
		}

		//前序遍历的第一个就是根节点，根据根节点把数组分成左右两个，递归
		TreeNode root = new TreeNode(preorder[0]);
		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == root.val) {
				index = i;
			}
		}
		int[] newPreOrder0 = new int[index];
		int[] newPreOrder1 = new int[inorder.length-1-index];
		System.arraycopy(preorder, 1, newPreOrder0, 0, newPreOrder0.length);
		System.arraycopy(preorder, index+1, newPreOrder1, 0, newPreOrder1.length);

		int[] newInOrder0 = new int[index];
		int[] newInOrder1 = new int[inorder.length-1-index];
		System.arraycopy(inorder, 0, newInOrder0, 0, newInOrder0.length);
		System.arraycopy(inorder, index+1, newInOrder1, 0, newInOrder1.length);
		root.left = build(newPreOrder0, newInOrder0);
		root.right = build(newPreOrder1, newInOrder1);

		return root;
	}
}
