package solution;

import java.util.ArrayList;
import java.util.List;

public class Solution0052 {
	int res;
	public int totalNQueens(int n) {
		res = 0;
		List<Integer> queens = new ArrayList<>();
		dfs(queens, n);
		return res;
	}

	//queens的长度表示目前排到第几行的皇后了，只需要考虑列
	public void dfs(List<Integer> queens, int n) {
		if (queens.size() == n) {
			res++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (isValid(queens, i)) {
				queens.add(i);
				dfs(queens, n);
				queens.remove(queens.size() - 1);
			}
		}
	}

	//会相互攻击
	public boolean isValid(List<Integer> queens, int col) {
		int row = queens.size();

		for (int i = 0; i < queens.size(); i++) {
			int pastRow = i;
			int pastCol = queens.get(i);

			if (pastCol == col || pastRow == row) {
				return false;
			}

			if (Math.abs(row-pastRow) == Math.abs(col-pastCol)) {
				return false;
			}
		}

		return true;
	}
}
