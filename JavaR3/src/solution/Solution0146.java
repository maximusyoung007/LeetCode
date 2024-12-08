package solution;

import java.util.HashMap;
import java.util.Map;

public class Solution0146 {
	//哈希表 双向链表
	static class LRUCache {

		class Node {
			Node pre;
			Node next;
			int val;
			int key;

			Node(int key, int val) {
				this.key = key;
				this.val = val;
			}
		}

		Node head;
		Node tail;
		Map<Integer, Node> map;
		int capacity;

		public LRUCache(int capacity) {
			head = new Node(-1, -1);
			tail = new Node(-1, -1);
			tail.pre = head;
			head.next = tail;
			map = new HashMap<>();
			this.capacity = capacity;
		}

		public int get(int key) {
			Node t;
			if (!map.containsKey(key)) {
				return -1;
			} else {
				t = map.get(key);
				del(t);
				add2Head(t);
			}

			return t.val;
		}

		public void put(int key, int value) {
			if (map.containsKey(key)) {
				Node t = map.get(key);
				t.val = value;

				del(t);
				add2Head(t);
			} else {
				Node t = new Node(key, value);
				add2Head(t);
				map.put(key, t);
			}

			if (map.size() > capacity) {
				int lastKey = delLast();
				map.remove(lastKey);
			}
		}

		public void del(Node node) {
			node.next.pre = node.pre;
			node.pre.next = node.next;
		}

		public void add2Head(Node node) {
			node.pre = head;
			head.next.pre = node;
			node.next = head.next;
			head.next = node;
		}

		public int delLast() {
			Node last = tail.pre;
			last.pre.next = tail;
			tail.pre = last.pre;

			return last.key;
		}

	}

	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache(2);
//		lRUCache.put(1, 1); // 缓存是 {1=1}
//		lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//		System.out.println(lRUCache.get(1));
//		lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//		System.out.println(lRUCache.get(2));
//		lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//		System.out.println(lRUCache.get(1));
//		System.out.println(lRUCache.get(3));
//		System.out.println(lRUCache.get(4));

		lRUCache.put(1,0);
		lRUCache.put(2,2);
		System.out.println(lRUCache.get(1));
		lRUCache.put(3,3);
		System.out.println(lRUCache.get(2));
		lRUCache.put(4,4);
		System.out.println(lRUCache.get(1));
		System.out.println(lRUCache.get(3));
		System.out.println(lRUCache.get(4));

	}
}
