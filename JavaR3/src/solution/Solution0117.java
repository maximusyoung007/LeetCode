package solution;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0117 {
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	public Node connect(Node root) {
		if (root == null) {
			return null;
		}

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		int k = 1;

		while (!queue.isEmpty()) {
			int nextK = 0;
			for (int i = 0; i < k; i++) {
				Node t1;
                t1 = queue.poll();
                if (i != k-1) {
                    Node t2 = queue.peek();
					t1.next = t2;
				} else {
                    t1.next = null;
				}

				if (t1.left != null) {
					queue.add(t1.left);
					nextK++;
				}

				if (t1.right != null) {
					queue.add(t1.right);
					nextK++;
				}
			}
			k = nextK;
		}

		return root;
	}

	public static void main(String[] args) {
		//[1,2,3,4,5,null,7]
		Solution0117 solution0117 = new Solution0117();
//		Integer[] treeArr = new Integer[] {1,2,3,4,5,null,7};;
//		Node root = solution0117.connect(solution0117.generateTree(new Integer[] {1,2,3,4,5,null,7}));
		Node root = solution0117.connect(solution0117.generateTree(new Integer[] {}));

		System.out.println("finished");
	}

	public Node generateTree(Integer[] treeArr) {
		if (treeArr == null || treeArr.length == 0) {
			return null;
		}
		Node node = new Node(treeArr[0]);

		Queue<Node> queue = new LinkedList<>();

		queue.add(node);

		int k = 1;
		while (!queue.isEmpty()) {
			Node t = queue.poll();
			if (k < treeArr.length && treeArr[k] != null) {
				Node l = new Node(treeArr[k]);
				t.left = l;
				queue.add(l);
			}
			k++;

			if (k < treeArr.length && treeArr[k] != null) {
				Node r = new Node(treeArr[k]);
				t.right = r;
				queue.add(r);
			}
			k++;
		}

		return node;
	}
}
