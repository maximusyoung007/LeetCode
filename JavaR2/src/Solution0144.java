import java.util.*;

public class Solution0144 {
	public List<Integer> preorderTraversal(TreeNode root) {
//		递归
//		List<Integer> res = new ArrayList<>();
//		if(root == null) {
//			return res;
//		}
//		preOrder(root, res);
//		return res;

		//迭代
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode t = stack.pop();
			res.add(t.val);

			if (t.right != null) {
				stack.add(t.right);
			}

			if (t.left != null) {
				stack.add(t.left);
			}
		}

		return res;
	}

	//递归解法
	public void preOrder(TreeNode root, List<Integer> res) {
		res.add(root.val);
		if (root.left != null) {
			preOrder(root.left, res);
		}
		if (root.right != null) {
			preOrder(root.right, res);
		}
	}
}
