/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/27      create
 */
public class Solution0547 {
	public int findCircleNum(int[][] isConnected) {
		int len = isConnected.length;
		boolean isVisited[] = new boolean[len];
		int count = 0;

		for (int i = 0; i < isVisited.length; i++) {
			//当前节点没有被访问过，则省份数量加1
			if (!isVisited[i]) {
				bfs(isConnected, isVisited, i);
				count++;
			}
		}

		return count;
	}

	//将和i相连的节点都改为true,保持在同一个省份中
	private void bfs(int[][] isConnected, boolean[] isVisited, int i) {
		//下标越界
		if (i < 0 || i > isConnected.length) {
			return;
		}

		isVisited[i] = true;

		for (int j = 0; j < isConnected[i].length; j++) {
			//j和i相连，且没有被访问过
			if (isConnected[i][j] == 1 && !isVisited[j]) {
				//再递归讨论和j相连的节点
				bfs(isConnected, isVisited, j);
			}
		}
	}
}
