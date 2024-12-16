package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0133 {
	static class Node {
		public int val;
		public List<Node> neighbors;
		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}
		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}
		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	//用这个map判读是否已经创建过了
	Map<Integer, Node> map = new HashMap<>();

	public Node cloneGraph(Node node) {
		return dfs(node);
	}

	public Node dfs(Node node) {
		if (node == null) {
			return null;
		}

		Node newNode;
		if (!map.containsKey(node.val)) {
			newNode = new Node(node.val);
			List<Node> newNeighbor = new ArrayList<>();
			List<Node> neighbor = node.neighbors;
			for (Node node1 : neighbor) {
				newNeighbor.add(dfs(node1));
			}
			newNode.neighbors = newNeighbor;
			map.put(node.val, newNode);
		} else {
			newNode = map.get(node.val);
		}


		return newNode;
	}

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		List<Node> neighbor1 = new ArrayList<>();
		neighbor1.add(node2);
		neighbor1.add(node4);
		node1.neighbors = neighbor1;
		List<Node> neighbor2 = new ArrayList<>();
		neighbor2.add(node1);
		neighbor2.add(node3);
		node2.neighbors = neighbor2;
		List<Node> neighbor3 = new ArrayList<>();
		neighbor3.add(node2);
		neighbor3.add(node4);
		node3.neighbors = neighbor3;
		List<Node> neighbor4 = new ArrayList<>();
		neighbor4.add(node1);
		neighbor4.add(node3);
		node4.neighbors = neighbor4;
		//cloneGraph(node1);
	}
}
