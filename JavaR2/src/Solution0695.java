/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/26      create
 */
public class Solution0695 {
	int count;
	public int maxAreaOfIsland(int[][] grid) {
		int m = grid.length, n = grid[0].length;

		boolean[][] visited = new boolean[m][n];

		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				//如果是陆地且没有被访问过
				if (grid[i][j] == 1 && !visited[i][j]) {
					count = 0;
					dfs(grid, visited, i, j);
					if (count > res) {
						res = count;
					}
				}
			}
		}
		return res;
	}

	private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
		//下标越界
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			return;
		}

		if (grid[i][j] == 1 && !visited[i][j]) {
			count++;
			visited[i][j] = true;
		} else {
			return;
		}

		dfs(grid, visited, i+1, j);
		dfs(grid, visited, i-1, j);
		dfs(grid, visited, i, j+1);
		dfs(grid, visited, i, j-1);
	}
}
