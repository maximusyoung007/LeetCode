package solution;

import java.util.HashMap;
import java.util.Map;

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}
public class Solution0138 {
	Map<Node, Node> map = new HashMap<>();

	//回溯，先把值创建好了，再返回来
	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}

		if (!map.containsKey(head)) {
			Node newNode = new Node(head.val);
			map.put(head, newNode);
			newNode.next = copyRandomList(head.next);
			newNode.random = copyRandomList(head.random);
		}

		return map.get(head);
	}

	public static void main(String[] args) {
		//[[7,null],[13,0],[11,4],[10,2],[1,0]]
		Node node1 = new Node(7);
		Node node2 = new Node(13);
		Node node3 = new Node(11);
		Node node4 = new Node(10);
		Node node5 = new Node(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node1.random = null;
		node2.random = node1;
		node3.random = node5;
		node4.random = node3;
		node5.random = node1;

		Solution0138 solution0138 = new Solution0138();
		Node res = solution0138.copyRandomList(node1);

		System.out.println("finished");
	}
}
