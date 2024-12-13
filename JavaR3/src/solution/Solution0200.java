package solution;

import java.util.Queue;

public class Solution0200 {
	public int numIslands(char[][] grid) {
		int m = grid.length, n = grid[0].length;
		boolean[][] isVisited = new boolean[m][n];

		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//如果找到一个没访问的到的，以此节点为起点开始广度优先遍历
				if (!isVisited[i][j]) {
					count++;
				}
			}
		}
	}

	//以i,j为起点开始广度优先遍历
	public void bfs(boolean[][] isVisited, int i, int j) {
		Queue<
	}
}
