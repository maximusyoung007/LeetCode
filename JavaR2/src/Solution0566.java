/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/8/22      create
 */
public class Solution0566 {
	public int[][] matrixReshape(int[][] mat, int r, int c) {
		int[][] res = new int[r][c];

		int r1 = 0, c1 = 0;

		int m = mat.length;
		int n = mat[0].length;

		if (m * n != r * c) {
			return mat;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[r1][c1] = mat[i][j];

				if (c1 < c - 1) {
					c1++;
				} else {
					r1++;
					c1 = 0;
				}
			}
		}

		return res;
	}
}
