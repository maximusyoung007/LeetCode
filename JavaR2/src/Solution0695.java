/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/26      create
 */
public class Solution0695 {
	int[][] nextIsland = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};

	public int maxAreaOfIsland(int[][] grid) {
		int m = grid.length, n = grid[0].length;

		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				//如果是陆地且没有被访问过
				if (grid[i][j] == 1 && !visited[i][j]) {

				}
			}
		}
		return 0;
	}

	private int dfs(int[][] grid, boolean[][] visited, )
}
