/**
 *  对应4个位置相互替换
 *  如 1  2  3  4  5
 *     6  7  8  9  10
 *     11 12 13 14 15
 *     16 17 18 19 20
 *     21 22 23 24 25
*   变换后为
 *   21 16 11 6  1
 *   22 17 12 7  2
 *   23 18 13 8  3
 *   24 19 14 9  4
 *   25 20 15 10 5
 *
 *
 *   1，5，25，21相互替换了位置
 *   2，10，24，16 相互替换了位置
 *   ...
 *   内层，7，9，19，17相互替换了位置
 *
 *   可以看到，外层循环到3，内层循环到8， 所有的数就已经完成了替换，即循环到 n/2即可
 *   1： (i，j)
 *   5： (j， n-i)
 *   25: (n-i,n-j)
 *   21: (n-j, i)
 *
 */
public class Solution0048 {
	public void rotate(int[][] matrix) {
		int n = matrix.length - 1;
		for (int i = 0; i <= n / 2; i++) {
			for (int j = i; j < n - i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-j][i];
				matrix[n-j][i] = matrix[n-i][n-j];
				matrix[n-i][n-j] = matrix[j][n-i];
				matrix[j][n-i] = temp;
			}
		}
	}
}
