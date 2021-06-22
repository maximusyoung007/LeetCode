import java.util.HashSet;
import java.util.Set;

/**
 * 给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。
 *
 * 示例 1:
 *
 * 输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
 *
 *      0          3
 *      |          |
 *      1 --- 2    4
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 *
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 *
 * 输出:  1
 * 注意:
 * 你可以假设在 edges 中不会出现重复的边。而且由于所以的边都是无向边，[0, 1] 与 [1, 0]  相同，所以它们不会同时在 edges 中出现。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-connected-components-in-an-undirected-graph
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0323 {
    int[] parent;
    int t;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        t = n;
        for (int i = 0; i < edges.length; i++) {
            merge(edges[i][0], edges[i][1], parent, t);
        }
        return t;
    }

    int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    void merge(int x, int y, int[] parent, int n) {
        int parentX = find(x, parent);
        int parentY = find(y, parent);
        if (parentX != parentY) {
            parent[parentY] = parentX;
            t--;
        }
    }
}
