import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution0218 {

	/**
	 * @宝贝萌她哥 的思路
	 * 假设[lefti, righti, heighti] 存放的是某一物种的出现、灭绝时间和能力值，某一时刻存活的能力值最高的物种统治世界。
	 * 要求得每次统治的开始时间和统治物种的能力值。
	 *
	 * 这样就很容易思考了：首先用（time，+/-ability）来记录每个物种的出现、灭绝时间（正负号用于区分是出现时间还是灭绝时间），
	 * 并按照时间顺序排序。维持一个大顶堆，
	 * 当一个物种出现时，将对应的能力值丢入大顶堆；
	 * 当一个物种灭绝时，将对应的能力从大顶堆中拿出。这样，大顶堆就时刻维持着当前统治的物种的能力值。进而求得每次统治的开始时间和对应能力值。
	 * 默认存在一个能力值为0，存在时间无限的憨憨物种兜底。
	 *
	 *
	 * @param buildings
	 * @return
	 */
	public List<List<Integer>> getSkyline(int[][] buildings) {
		List<int[]> p = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();

		int pre = 0;

		for (int[] building : buildings) {
			int l = building[0];
			int r = building[1];
			int h = building[2];
			//左节点高度为负的可以保证先遍历左节点
			int[] t1 = new int[] {l, -h};
			int[] t2 = new int[] {r, h};
			p.add(t1);
			p.add(t2);
		}

		//先对坐标排序，再对高度排序
		Collections.sort(p, (a, b) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			} else {
				return a[1] - b[1];
			}
		});

		PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
		queue.add(0);

		for (int[] point : p) {
			if (point[1] < 0) {
				queue.add(-point[1]);
			} else {
				queue.remove(point[1]);
			}

			int now = queue.peek();
			//每次有新的高度入队，或者旧的高度出队，都会有转折点，其坐标即为point[0], 高度为入队或者出队后的最高高度
			//如果入队或者出队后，高度没有变化，则不存在转折点, 所以只考虑高度变化的情况
			if (now != pre) {
//				int[] ps = new int[] {point[0], now};
				List<Integer> ps = new ArrayList<>();
				ps.add(point[0]);
				ps.add(now);
				pre = now;
				res.add(ps);
			}

		}
		return res;
	}

}
