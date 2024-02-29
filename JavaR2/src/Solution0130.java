/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/29      create
 */
public class Solution0130 {
	public void solve(char[][] board) {
		int m = board.length, n = board[0].length;

		boolean[][] visited = new boolean[m][n];

		//不访问X
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X') {
					visited[i][j] = true;
				}
			}
		}

		//先遍历边界上的O, 将边界上的O变为B
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0 || i == m-1 || j == n-1) {
					dfs(board, i, j, visited);
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == 'B') {
					board[i][j] = 'O';
				}
			}
		}
	}

	private void dfs(char[][] board, int i, int j, boolean[][] visited) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return;
		}

		if (visited[i][j]) {
			return;
		}

		visited[i][j] = true;

		if (board[i][j] == 'O') {
			board[i][j] = 'B';
		}

		dfs(board, i+1, j, visited);
		dfs(board, i-1, j, visited);
		dfs(board, i, j+1, visited);
		dfs(board, i, j-1, visited);
	}
}
