import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/10/16      create
 */
public class Solution0146 {
	//双向链表， 访问后将节点移到链表末尾，新增时，如果超过了容量，将链表第一个节点出队
	static class LRUCache {
		private static class Node {
			private int key;
			private int value;
			private Node pre;
			private Node next;

			Node(int key, int value, Node pre, Node next) {
				this.key = key;
				this.value = value;
				this.pre = pre;
				this.next = next;
			}
		}

		Map<Integer, Node> map;
		int capacity;
		Node head;
		Node tail;

		public LRUCache(int capacity) {
			map = new HashMap<>();
			this.capacity = capacity;
			head = new Node(-1, -1, null, null);
			tail = new Node(-1, -1, null, null);
		}

		public int get(int key) {
			if (!map.containsKey(key)) {
				return -1;
			}
			Node n = map.get(key);
			move2Tail(n);
			return n.value;
		}

		public void put(int key, int value) {
			if (!map.containsKey(key)) {
				Node node = new Node(key, value, null, null);

				if (map.size() >= 1) {
					Node tailPre = tail.pre;
					tailPre.next = node;
					node.pre = tailPre;
					node.next = tail;
					tail.pre = node;
				} else {
					head.next = node;
					node.pre = head;
					node.next = tail;
					tail.pre = node;
				}
				map.put(key, node);

				if (map.size() > capacity) {
					Node del = head.next;
					del.next.pre = head;
					head.next = del.next;
					del.pre = null;
					del.next = null;
					map.remove(del.key);
				}
			} else {
				Node newNode = map.get(key);
				newNode.value = value;
				map.put(key, newNode);

				move2Tail(newNode);

			}
		}

		private void move2Tail(Node n) {
			if (map.size() == 2 && n.pre == head) {
				head.next = n.next;
				Node nextNode = n.next;
				nextNode.pre = head;
				nextNode.next = n;
				n.pre = nextNode;
				n.next = tail;
				tail.pre = n;
			} else {
				Node preNode = n.pre;
				Node nextNode = n.next;
				preNode.next = n.next;
				nextNode.pre = n.pre;
				Node tailPre = tail.pre;
				tailPre.next = n;
				n.pre = tailPre;
				n.next = tail;
				tail.pre = n;
			}
		}
	}
}
