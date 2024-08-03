import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author maximusyoung
 * 遍历list的时候，只把每个ListNode链表的头节点入队，可以保证值相同的listNode是按顺序入队的
 * 如-2 -1 -1 -1，第一次入队的时候，入队-2，那么后面三个-1，一定是按顺序入队的
 * 如果一次性把-2 -1 -1 -1都入队，获取的时候，最后一个-1会先于其他两个-1入队，会造成死循环
 */
public class Solution0023 {
	static Comparator<ListNode23> cmp = new Comparator<ListNode23>() {
		@Override
		public int compare(ListNode23 o1, ListNode23 o2) {
			return o1.val - o2.val;
		}
	};
	public ListNode23 mergeKLists(ListNode23[] lists) {
		PriorityQueue<ListNode23> queue = new PriorityQueue<>(cmp);

		for (int i = 0; i < lists.length; i++) {
			ListNode23 t = lists[i];
			if (t != null) {
				queue.add(t);
			}
		}

		ListNode23 res = new ListNode23();
		ListNode23 tmp = res;
		while (!queue.isEmpty()) {
			ListNode23 t = queue.poll();
			tmp.next = t;
			tmp = tmp.next;
			if (t.next != null) {
				queue.add(t.next);
			}
		}
		return res.next;
	}
}

class ListNode23 {
	int val;
	ListNode23 next;
	ListNode23() {}
	ListNode23(int val) { this.val = val; }
    ListNode23(int val, ListNode23 next) { this.val = val; this.next = next; }
}
