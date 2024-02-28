import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/28      create
 */
public class Solution0934 {
	int[][] nextMoves = new int[][] {{1,0}, {-1,0}, {0,-1}, {0,1}};
	public int shortestBridge(int[][] grid) {
		int i1 = 0, j1 = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					i1 = i;
					j1 = j;
				}
			}
		}
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Queue<int[]> queue = new LinkedList<>();
		bfs(grid, i1, j1, visited, queue);

		int res = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			//一层一层遍历，如果遍历到0，就入队，算作下一层的，同时连接数+1，如果遍历到1，表示已经连接到了，就返回结果
			for (int i = 0; i < size; i++) {
				int[] q = queue.poll();
				for (int[] next : nextMoves) {
					int nextI = q[0] + next[0];
					int nextJ = q[1] + next[1];

					if (nextI < 0 || nextI >= grid.length || nextJ < 0 || nextJ >= grid[0].length) {
						continue;
					}

					if (grid[nextI][nextJ] == 0) {
						grid[nextI][nextJ] = 2;
						queue.add(new int[] {nextI, nextJ});
					} else if (grid[nextI][nextJ] == 2) {
						continue;
					} else {
						return res;
					}
				}
			}
			res++;
		}
		return 0;
	}

	private void bfs(int[][] grid, int i, int j, boolean[][] visited, Queue<int[]> queue) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			return;
		}

		if (visited[i][j]) {
			return;
		}

		visited[i][j] = true;

		if (grid[i][j] == 0) {
			return;
		} else if (grid[i][j] == 1) {
			grid[i][j] = 2;
			queue.add(new int[] {i, j});
		}

		bfs(grid, i+1, j, visited, queue);
		bfs(grid, i-1, j, visited, queue);
		bfs(grid, i, j-1, visited, queue);
		bfs(grid, i, j+1, visited, queue);

	}
}
