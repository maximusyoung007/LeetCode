package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution0530 {
	//中序遍历非递归
	public int getMinimumDifference(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Stack<TreeNode> stack = new Stack<>();

		stack.push(root);

		int min = Integer.MAX_VALUE;
		int pre = -1;
		int sub;

		TreeNode cur = root;

		while (!stack.isEmpty()) {
			while (cur.left != null) {
				cur = cur.left;
				stack.push(cur);
			}

			TreeNode t = stack.pop();
			sub = t.val - pre;
			if (pre != -1 && sub < min) {
				min = sub;
			}
			pre = t.val;

			if (t.right != null) {
				stack.push(t.right);
				cur = t.right;
			}
		}

		return min;
	}

	//中序遍历递归
	List<Integer> list;
	int min;
	public int getMinimumDifference2(TreeNode root) {
		min = Integer.MAX_VALUE;
		list = new ArrayList<>();
		preOrder(root, list);
		return min;
	}

	public void preOrder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}

		preOrder(root.left, list);

		if (!list.isEmpty()) {
			int sub = root.val - list.get(list.size() - 1);
			if (sub < min) {
				min = sub;
			}
		}
		list.add(root.val);

		preOrder(root.right, list);

	}
}
