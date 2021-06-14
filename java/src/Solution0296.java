import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 有一队人（两人或以上）想要在一个地方碰面，他们希望能够最小化他们的总行走距离。
 *
 * 给你一个 2D 网格，其中各个格子内的值要么是 0，要么是 1。
 *
 * 1 表示某个人的家所处的位置。这里，我们将使用 曼哈顿距离 来计算，其中 distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|。
 *
 * 示例：
 *
 * 输入:
 *
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 *
 * 输出: 6
 *
 * 解析: 给定的三个人分别住在(0,0)，(0,4) 和 (2,2):
 *      (0,2) 是一个最佳的碰面点，其总行走距离为 2 + 2 + 2 = 6，最小，因此返回 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-meeting-point
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0296 {
    public int minTotalDistance(int[][] grid) {
        if (grid.length < 1) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }

        Collections.sort(y);
        int x1 = x.get(x.size() / 2);
        int y1 = y.get(y.size() / 2);

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result += Math.abs(x1 - i);
                    result += Math.abs(y1 - j);
                }
            }
        }
        return result;
    }
}
