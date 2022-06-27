public class Solution1143 {
	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length(), n = text2.length();
		text1 = " " + text1;
		text2 = " " + text2;

		int[][] f = new int[m + 1][n + 1];

		for (int i = 0; i < m; i++) {
			f[i][0] = 1;
		}

		for (int j = 0; j < n; j++) {
			f[0][j] = 1;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (text1.charAt(i) == text2.charAt(j)) {
					f[i][j] = f[i-1][j-1] + 1;
				} else {
					f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
				}
			}
		}
		return f[m][n] - 1;
	}
}
