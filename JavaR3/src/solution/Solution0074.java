package solution;

public class Solution0074 {
	public boolean searchMatrix(int[][] matrix, int target) {
		int i = 0, j = matrix[0].length-1;

		//从右上角开始遍历，右上角是第i行最大的，第j行最小的
		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] > target) {
				//第j列的都大于target,j左移
				j--;
			} else if (matrix[i][j] < target) {
				//第i行的都小于target
				i++;
			}
		}

		return false;
	}
}
