public class Solution0329 {
	int res = 0;
	int[][] next = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public int longestIncreasingPath(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] counted = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int count = dfs(counted, i, j, m, n, matrix);
				res = Math.max(count, res);
			}
		}
		return res;
	}

	//每次查找周围最大的长度+1,如果周围没有比自己大的，就置为1
	public int dfs(int[][] count, int i, int j, int m, int n, int[][] matrix) {
		if (count[i][j] != 0) {
			return count[i][j];
		}
		count[i][j] = 1;
		for (int c = 0; c < next.length; c++) {
			int i1 = i + next[c][0];
			int j1 = j + next[c][1];
			if (i1 >= 0 && i1 < m && j1 >= 0 && j1 < n && matrix[i1][j1] < matrix[i][j]) {
				count[i][j] = Math.max(count[i][j], dfs(count, i1, j1, m, n, matrix) + 1);
			}
		}
		return count[i][j];
	}

	//朴素dfs超时
//	public void dfs(boolean[][] used, int[][] matrix, int i, int j, int oldI, int oldJ, int current) {
//		int m = matrix.length;
//		int n = matrix[0].length;
//		if (used[i][j]) {
//			return;
//		}
//		used[i][j] = true;
//		if ((oldI == -1 && oldJ == -1) || matrix[i][j] > matrix[oldI][oldJ]) {
//			current++;
//			if (current > res) {
//				res = current;
//			}
//			//counted[i][j] = true;
//		}
//		if (oldI != -1 && matrix[i][j] <= matrix[oldI][oldJ]) {
//			return;
//		}
//		if (i + 1 >= 0 && i + 1 < m) {
//			dfs(used, matrix, i + 1, j, i, j, current);
//			used[i + 1][j] = false;
//		}
//		if (j + 1 >= 0 && j + 1 < n) {
//			dfs(used, matrix, i, j + 1, i, j, current);
//			used[i][j + 1] = false;
//		}
//		if (i - 1 >= 0 && i - 1 < m) {
//			dfs(used, matrix, i - 1, j, i, j, current);
//			used[i - 1][j] = false;
//		}
//		if (j - 1 >= 0 && j - 1 < n) {
//			dfs(used, matrix, i, j - 1, i, j, current);
//			used[i][j - 1] = false;
//		}
//	}
}