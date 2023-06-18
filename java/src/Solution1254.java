public class Solution1254 {
	boolean reach;
	public int closedIsland(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int res = 0;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}
		//从1到m-1，是因为不能包含边界
		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				//访问到了陆地，并且这块陆地没有被访问过
				if (grid[i][j] == 0 && !visited[i][j]) {
					reach = false;
					dfs(i, j, grid, visited);
					if (!reach) {
						res++;
					}
				}
			}
		}
		return res;
	}

	public void dfs(int i, int j, int[][] grid, boolean[][] visited) {
		if (i == 0 || i == grid.length - 1 || j == 0 || j == grid[i].length - 1) {
			//到达边界
			if (grid[i][j] == 0) {
				reach = true;
			}
			return;
		}
		//访问过的节点或者为1
		if (grid[i][j] == 1 || visited[i][j] == true) {
			return;
		}
		visited[i][j] = true;
		dfs(i+1, j, grid, visited);
		dfs(i, j+1, grid, visited);
		dfs(i-1, j, grid, visited);
		dfs(i, j-1, grid, visited);
	}
}
