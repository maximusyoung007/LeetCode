import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/8/20      create
 */
public class Solution0332 {
	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, List<String>> map = new HashMap<>();

		for (List<String> ticket : tickets) {
			String t1 = ticket.get(0);
			String t2 = ticket.get(1);
			List<String> list;
			if (map.containsKey(t1)) {
				list = map.get(t1);
			} else {
				list = new LinkedList<>();
			}
			list.add(t2);
			map.put(t1, list);
		}

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			Collections.sort(entry.getValue());
		}

		Stack<String> stack = new Stack<>();
		stack.push("JFK");

		List<String> res = new ArrayList<>();

		//循环遍历map，遇到有下一个节点的，就将字典序最小的下一个节点入栈，并将这个点删除；如果没有下一个几点，就表示此节点是当前最小的节点，加入到结果集中
		//结果集中节点是从最后一个节点开始加，一直加到第一个节点JFK，因此最终输出的结果要倒序
		while (!stack.isEmpty()) {
			String t = stack.peek();
			if (map.get(t) == null || map.get(t).isEmpty()) {
				res.add(t);
				stack.pop();
			} else {
				List<String> list = map.get(t);
				stack.push(list.get(0));
				list.remove(0);
				map.put(t, list);
			}
		}
		Collections.reverse(res);

		return res;
	}
}
