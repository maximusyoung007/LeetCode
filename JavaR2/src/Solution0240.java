/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/8/1      create
 */
public class Solution0240 {
	int ri = -1, rj = -1;
	public boolean searchMatrix(int[][] matrix, int target) {
		int i = 0, j = matrix[0].length - 1;
		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] > target) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}

	//类似于DFS的解法，不可用，超时
	private void search(int i, int j, int[][] matrix, int target) {
		if (ri != -1 && rj != -1) {
			return;
		}
		if (i > matrix.length - 1) {
			return;
		}
		if (j > matrix[0].length - 1) {
			return;
		}
		if (matrix[i][j] > target) {
			return;
		}
		if (matrix[i][j] == target) {
			ri = i;
			rj = j;
			return;
		}

		search(i+1, j, matrix, target);
		search(i, j+1, matrix, target);
	}
}
