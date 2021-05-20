import java.util.Arrays;

/**
 * 261. 以图判树
 * 给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。
 *
 * 示例 1：
 *
 * 输入: n = 5, 边列表 edges = [[0,1], [0,2], [0,3], [1,4]]
 * 输出: true
 * 示例 2:
 *
 * 输入: n = 5, 边列表 edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * 输出: false
 */
public class Solution0261 {
    int f[];
    void init(int n) {
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
    }
    int find(int x) {
        if (x == f[x]) {
            return x;
        }
        return f[x] = find(f[x]);
    }
    void merge(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        f[fx] = fy;
    }
    int count() {
        int count = 0;
        for (int i = 0; i < f.length; i++) {
            if (find(i) == i) {
                count++;
            }
        }
        return count;
    }
    public boolean validTree(int n, int[][] edges) {
        f = new int[n];
        init(n);
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            merge(a, b);
        }
        return edges.length + 1 == n && count() == 1;
    }
}
