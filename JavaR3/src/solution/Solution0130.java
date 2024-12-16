package solution;

public class Solution0130 {
	public void solve(char[][] board) {
		int m = board.length, n = board[0].length;
		//不会被捕获的区域
		boolean[][] noSolved = new boolean[m][n];

		//从边界出发，判断所有和边界相连的O，都是不需要更新的
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O' && !noSolved[0][j]) {
				dfs(board, noSolved, 0, j);
			}

			if (board[m-1][j] == 'O' && !noSolved[m-1][j]) {
				dfs(board, noSolved, m-1, j);
			}
		}

		for (int i = 1; i < m-1; i++) {
			if (board[i][0] == 'O' && !noSolved[i][0]) {
				dfs(board, noSolved, i, 0);
			}

			if (board[i][n-1] == 'O' && !noSolved[i][n-1]) {
				dfs(board, noSolved, i, n-1);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O' && !noSolved[i][j]) {
					board[i][j] = 'X';
				}
			}
		}
	}

	public void dfs(char[][] board, boolean[][] noSolved, int i, int j) {
		int m = board.length, n = board[0].length;

		noSolved[i][j] = true;

		int[][] next = new int[][] {
			{1,0}, {-1,0}, {0,1}, {0,-1}
		};

		for (int k = 0; k < next.length; k++) {
			int nextI = i + next[k][0];
			int nextJ = j + next[k][1];

			if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && board[nextI][nextJ] == 'O' && !noSolved[nextI][nextJ]) {
				dfs(board, noSolved, nextI, nextJ);
			}
		}
	}
}
