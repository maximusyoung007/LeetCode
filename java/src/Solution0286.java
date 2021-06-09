import java.util.LinkedList;
import java.util.Queue;

/**
 * 你被给定一个 m × n 的二维网格 rooms ，网格中有以下三种可能的初始化值：
 *
 *     -1 表示墙或是障碍物
 *     0 表示一扇门
 *     INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 的。
 *
 * 你要给每个空房间位上填上该房间到 最近门的距离 ，如果无法到达门，则填 INF 即可。
 *
 * 输入：rooms = [
 *                  [2147483647,-1,0,2147483647],
 *                  [2147483647,2147483647,2147483647,-1],
 *                  [2147483647,-1,2147483647,-1],
 *                  [0,-1,2147483647,2147483647]
*               ]
 * 输出：[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
 *
 * 示例 2：
 *
 * 输入：rooms = [[-1]]
 * 输出：[[-1]]
 *
 * 示例 3：
 *
 * 输入：rooms = [[2147483647]]
 * 输出：[[2147483647]]
 *
 * 示例 4：
 *
 * 输入：rooms = [[0]]
 * 输出：[[0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walls-and-gates
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0286 {
    final int INF = 2147483647;
    public void wallsAndGates(int[][] rooms) {
        int[][] steps = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int n = rooms.length;
        if (n <= 0) {
            return;
        }
        int m = rooms[0].length;
        if (m <= 0) {
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //将门入队
                if (rooms[i][j] == 0) {
                    int[] t = new int[] {i, j};
                    queue.add(t);
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] currentPoint = queue.poll();
            int currentX = currentPoint[0];
            int currentY = currentPoint[1];
            for (int i = 0; i < steps.length; i++) {
                int nextX = currentX + steps[i][0];
                int nextY = currentY + steps[i][1];
                //如果节点越界，或者这个节点已经遍历过了，广度优先遍历，先遍历的节点值肯定会更小
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m || rooms[nextX][nextY] != INF) {
                    continue;
                }
                //节点入队进行下一轮循环
                rooms[nextX][nextY] = rooms[currentX][currentY] + 1;
                int[] t = new int[] {nextX, nextY};
                queue.add(t);
            }
        }
    }
}
