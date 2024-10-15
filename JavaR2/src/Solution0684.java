/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/10/15      create
 */
public class Solution0684 {
	/**
	 * 使用并查集，判断两个节点是否重复连通
	 * 从前往后依次判断每个edge，这样有多个的情况，最后一个就是结果
	 * @param edges
	 * @return
	 */
	int[] p;
	public int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;

		p = new int[n+1];
		//初始化
		for (int i = 0; i <= n; i++) {
			p[i] = i;
		}

		int[] res = null;
		for (int[] edge : edges) {
			int fa = find(edge[0]);
			int fb = find(edge[1]);
			//如果首次遍历到两个节点就有共同的祖先，则表示之前通过其他节点相连了
			if (fa == fb) {
				res = edge;
			}
			//合并，把fa的祖先变成fb
			p[fa] = fb;
		}

		return res == null ? new int[] {-1, -1} : res;
	}

	private int find(int x) {
		if (p[x] == x) {
			return x;
		} else {
			//路径压缩，首次压缩后，下次再查找这个路径上的点，就可以直接找到父节点
			p[x] = find(p[x]);
			return p[x];
		}
	}

}
