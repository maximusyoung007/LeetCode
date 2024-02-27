import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/27      create
 */
public class Solution0417 {
	int[][] nextMoves = new int[][] {{1,0}, {-1,0}, {0,-1}, {0,1}};

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		int m = heights.length, n = heights[0].length;

		//count初始化为0,可以流向大西洋+1,可以流向太平洋再+1,等于2的则为节点
		int[][] counts = new int[m][n];
		boolean[][] visited;

		//从边界开始向里递归
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//太平洋流入
				if (i == 0 || j == 0) {
					//一个节点可能从不同的路径流向太平洋，每次都是1条新的路径，因此重置visited数组
					visited = new boolean[m][n];
					dfs1(i, j, -1, -1, heights, counts, visited, true);

				}

				//大西洋流入
				if (i == m - 1 || j == n - 1) {
					visited = new boolean[m][n];
					dfs1(i, j, -1, -1, heights, counts, visited, false);
				}
			}
		}

		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (counts[i][j] == 2) {
					res.add(Arrays.asList(new Integer[] {i, j}));
				}
			}
		}

		return res;
	}

	private void dfs1(int i, int j, int oldI, int oldJ, int[][] heights, int[][] counts, boolean[][] visited, boolean isPacific) {
		if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length) {
			return;
		}

		//已经访问过的节点不再访问
		if (visited[i][j]) {
			return;
		}

		visited[i][j] = true;

		//oldI==-1 && oldJ==-1表示在边界上，一定满足
		if (oldI == -1 && oldJ == -1) {
			if (isPacific) {
				if (counts[i][j] == 0) {
					counts[i][j]++;
				}
			} else {
				if (counts[i][j] == 1) {
					counts[i][j]++;
				}
			}
		} else {
			//否则要比较大小
			if (heights[i][j] >= heights[oldI][oldJ]) {
				if (isPacific) {
					if (counts[i][j] == 0) {
						counts[i][j]++;
					}
				} else {
					if (counts[i][j] == 1) {
						counts[i][j]++;
					}
				}
			} else {
				return;
			}
		}

		for (int[] nextMove : nextMoves) {
			int nextI = i + nextMove[0];
			int nextJ = j + nextMove[1];

			dfs1(nextI, nextJ, i, j, heights, counts, visited, isPacific);

		}
		return;
	}
}
