package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution0909 {
	public int snakesAndLadders(int[][] board) {
		int n = board.length;

		//map记录数字对应的下标
		Map<Integer, Integer[]> m = new HashMap<>();

		int num = 1;
		int direct = 1;
		for (int i = n - 1; i >= 0; i--) {

			if (direct == 1) {
				for (int j = 0; j < n; j++) {
					m.put(num, new Integer[] {i, j});
					num++;
				}
			} else {
				for (int j = n - 1; j >= 0; j--) {
					m.put(num, new Integer[] {i, j});
					num++;
				}
			}

			direct *= -1;
		}

		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		queue.add(1);
		visited.add(1);
		int k = 1;
		int count = 0;

		while (!queue.isEmpty()) {
			int tk = 0;
			for (int i = 0; i < k; i++) {
				int t = queue.poll();

				if (t == n * n) {
					return count;
				}

				int min = Math.min(t+6, n * n);
				for (int j = t + 1; j <= min; j++) {

					int boardI = m.get(j)[0];
					int boardJ = m.get(j)[1];

					if (board[boardI][boardJ] != -1 && !visited.contains(board[boardI][boardJ])) {
						queue.add(board[boardI][boardJ]);
						visited.add(board[boardI][boardJ]);
						tk++;
					} else if (board[boardI][boardJ] == -1 && !visited.contains(j)){
						queue.add(j);
						visited.add(j);
						tk++;

					}
				}
			}

			count++;
			k = tk;
		}

		return -1;

	}
}
