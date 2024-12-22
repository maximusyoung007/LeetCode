package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution0079 {
	public boolean exist(char[][] board, String word) {
		int m = board.length, n = board[0].length;
		String s = "";
		boolean res;
		boolean[][] isVisited;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				isVisited = new boolean[m][n];
				if (board[i][j] == word.charAt(0)) {
					s = s + board[i][j];
					isVisited[i][j] = true;
					res = dfs(board, word, s, i, j, m, n, isVisited);
					isVisited[i][j] = false;
					s = "";
					if (res) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean dfs(char[][] board, String word, String s, int i, int j, int m, int n, boolean[][] isVisited) {

		if (s.length() > word.length()) {
			return false;
		}

		if (s.length() > 1 && s.charAt(s.length()-1) != word.charAt(s.length()-1)) {
			return false;
		}

		if (s.equals(word)) {
			return true;
		}

		int[][] nexts = new int[][] {
			{0,1}, {0,-1}, {1,0}, {-1,0}
		};

		boolean res;
		for (int[] next : nexts) {
			int nextI = i + next[0];
			int nextJ = j + next[1];

			if (nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n || isVisited[nextI][nextJ]) {
				continue;
			}

			isVisited[nextI][nextJ] = true;
			s = s + board[nextI][nextJ];
			res = dfs(board, word, s, nextI, nextJ, m, n, isVisited);
			isVisited[nextI][nextJ] = false;
			s = s.substring(0, s.length()-1);

			if (res) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] a = new int[1];
		int k = 1;
		List<Integer> a1 = new ArrayList<>();
		a1.add(1);
		testDfs(a, k);
		testDfs2(a1, k);
	}

	public static void testDfs(int[] a, int k) {
		if (k == 2) {
			a[0] = 100;
			return;
		}

		System.out.println("k:" + k + "a[0]:" + a[0]);

		int t = k+1;
		testDfs(a, t);

		System.out.println("k:" + k + "a[0]:" + a[0]);
	}

	public static void testDfs2(List<Integer> a, int k) {
		if (k == 2) {
			a.remove(a.size()-1);
			a.add(100);
			return;
		}

		System.out.println("k:" + k + "a[0]:" + a.get(0));

		int t = k+1;
		testDfs2(a, t);

		System.out.println("k:" + k + "a[0]:" + a.get(0));
	}

}
