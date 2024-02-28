/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/28      create
 */
public class Solution0079 {
	int[][] nextMoves = new int[][] {{1,0}, {-1,0}, {0,-1}, {0,1}};
	boolean res = false;

	public boolean exist(char[][] board, String word) {
		boolean[][] visited;
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				visited = new boolean[m][n];
				bfs(board, i, j, word, 0, visited);
			}
		}
		return res;
	}

	private void bfs(char[][] board, int i, int j, String word, int k, boolean[][] visited) {
		if (res) {
			return;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return;
		}

		if (visited[i][j]) {
			return;
		}

		if (board[i][j] == word.charAt(k)) {
			if (k == word.length() - 1) {
				res = true;
				return;
			}
			visited[i][j] = true;
		} else {
			return;
		}

		int direct = 0;
		for (int[] nextMove : nextMoves) {
			direct++;
			int nextI = i + nextMove[0];
			int nextJ = j + nextMove[1];

			k += 1;
			bfs(board, nextI, nextJ, word, k, visited);
			k -= 1;
			//如果4个方向都试过了，并且不为true，则当前位置也不合适
			if (direct == 4 && !res) {
				visited[i][j] = false;
			}
		}

	}
}
