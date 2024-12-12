package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution0173 {
	//用栈实现非递归中序遍历
	static class BSTIterator {
		Stack<TreeNode> stack;
		TreeNode current;

		public BSTIterator(TreeNode root) {
			stack = new Stack<>();
			current = root;
			//沿着左子树前进
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
		}

		public int next() {
			current = stack.pop();
			int nextVal = current.val;

			//转移到右子树
			if (current.right != null) {
				current = current.right;
				//再沿着左子树前进
				while (current != null) {
					stack.push(current);
					current = current.left;
				}
			}

			return nextVal;
		}

		public boolean hasNext() {
			if (!stack.isEmpty()) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		BSTIterator bstIterator = new BSTIterator(generateTree(new Integer[]{7,3,15,null,null,9,20}));
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.hasNext());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.hasNext());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.hasNext());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.hasNext());
	}

	public static TreeNode generateTree(Integer[] treeArr) {
		if (treeArr.length == 0) {
			return null;
		}
		TreeNode node = new TreeNode(treeArr[0]);

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(node);

		int k = 1;
		while (!queue.isEmpty()) {
			TreeNode t = queue.poll();
			if (k < treeArr.length && treeArr[k] != null) {
				TreeNode l = new TreeNode(treeArr[k]);
				t.left = l;
				queue.add(l);
			}
			k++;

			if (k < treeArr.length && treeArr[k] != null) {
				TreeNode r = new TreeNode(treeArr[k]);
				t.right = r;
				queue.add(r);
			}
			k++;
		}

		return node;
	}
}
