/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/8/21      create
 */
public class Solution0304 {
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{3,0,1,4,2},
			{5,6,3,2,1},
			{1,2,0,1,5},
			{4,1,0,1,7},
			{1,0,3,0,5}
		};
		NumMatrix numMatrix = new NumMatrix(matrix);
		System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
		System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
	}
}

class NumMatrix {
	int[][] prefixSum;
	public NumMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		prefixSum = new int[++m][++n];

		//第一行，第一列补充0，便于计算i=0或者j=0的情况
		for (int i = 0; i < m; i++) {
			prefixSum[i][0] = 0;
		}
		for (int j = 0; j < n; j++) {
			prefixSum[0][j] = 0;
		}

		//int sum = 0;
		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				prefixSum[i+1][j+1] = matrix[i][j] + prefixSum[i][j+1] + prefixSum[i+1][j] - prefixSum[i][j];
			}
		}

	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return prefixSum[row2+1][col2+1] - prefixSum[row1][col1] -
			(prefixSum[row1][col2+1] - prefixSum[row1][col1]) - (prefixSum[row2+1][col1] - prefixSum[row1][col1]);
	}
}
