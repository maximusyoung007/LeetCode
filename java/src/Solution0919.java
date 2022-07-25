import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0919 {
	public static void main(String[] args) {
//		TreeNode
//		CBTInserter cbtInserter = new CBTInserter();
	}
}

class CBTInserter {
	TreeNode root;
	Queue<TreeNode> queue;

	public CBTInserter(TreeNode root) {
		this.root = root;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node.left != null) {
				q.offer(node.left);
			}
			if (node.right != null) {
				q.offer(node.right);
			}
			if (node.left == null || node.right == null) {
				queue.offer(node);
			}
		}
	}

	public int insert(int val) {
		TreeNode node = new TreeNode(val);
		TreeNode t = queue.peek();
		int value = t.val;
		if (t.left == null) {
			t.left = node;
		} else if (t.right == null) {
			t.right = node;
			queue.poll();
		}
		queue.offer(node);
		return value;
	}

	public TreeNode get_root() {
		return root;
	}
}
