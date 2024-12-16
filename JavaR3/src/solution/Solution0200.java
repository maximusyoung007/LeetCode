package solution;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0200 {
	public int numIslands(char[][] grid) {
		int m = grid.length, n = grid[0].length;
		boolean[][] isVisited = new boolean[m][n];

		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//如果找到一个没访问的到的岛屿，以此节点为起点开始广度优先遍历
				if (!isVisited[i][j] && grid[i][j] == '1') {
					count++;
					//bfs(grid, isVisited, i, j);
					//本题深度优先遍历更快点
					dfs(grid, isVisited, i, j);
				}
			}
		}

		return count;
	}

	//以i,j为起点开始广度优先遍历
	public void bfs(char[][]grid, boolean[][] isVisited, int i, int j) {
		int[][] next = new int[][] {
			{1,0}, {-1,0}, {0,1}, {0,-1}
		};
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{i, j});
		isVisited[i][j] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentI = current[0];
			int currentJ = current[1];

			for (int k = 0; k < 4; k++) {
				int nextI = currentI + next[k][0];
				int nextJ = currentJ + next[k][1];

				if (nextI >= 0 && nextI < grid.length && nextJ >= 0 && nextJ < grid[0].length &&
					!isVisited[nextI][nextJ] &&
					grid[nextI][nextJ] == '1'
				) {
					isVisited[nextI][nextJ] = true;
					queue.add(new int[] {nextI, nextJ});
				}
			}
		}

	}

	public void dfs(char[][]grid, boolean[][] isVisited, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || isVisited[i][j] || grid[i][j] == '0') {
			return;
		}

		isVisited[i][j] = true;

		dfs(grid, isVisited, i+1, j);
		dfs(grid, isVisited, i-1, j);
		dfs(grid, isVisited, i, j+1);
		dfs(grid, isVisited, i, j-1);
	}
}
