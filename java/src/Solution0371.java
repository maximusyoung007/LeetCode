import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *你是个房地产开发商，想要选择一片空地 建一栋大楼。你想把这栋大楼够造在一个距离周边设施都比较方便的地方，通过调研，你希望从它出发能在 最短的距离和 内抵达周边全部的建筑物。请你计算出这个最佳的选址到周边全部建筑物的 最短距离和。
 *
 * 提示：
 *
 * 你只能通过向上、下、左、右四个方向上移动。
 *
 * 给你一个由 0、1 和 2 组成的二维网格，其中：
 *
 * 0 代表你可以自由通过和选择建造的空地
 * 1 代表你无法通行的建筑物
 * 2 代表你无法通行的障碍物
 *  
 * 示例：
 *
 * 输入：[[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 *
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * 输出：7
 * 解析：
 * 给定三个建筑物 (0,0)、(0,4) 和 (2,2) 以及一个位于 (0,2) 的障碍物。
 * 由于总距离之和 3+3+1=7 最优，所以位置 (1,2) 是符合要求的最优地点，故返回7。
 *  
 * 注意：
 *
 * 题目数据保证至少存在一栋建筑物，如果无法按照上述规则返回建房地点，则请你返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-distance-from-all-buildings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0371 {
    //当前节点到各个节点的距离
    int[][] distance;
    //到达建筑物的数量
    int num = 0;
    int[][] nextMove = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int minSum = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //障碍物和建筑不能作为起点
                if (grid[i][j] == 2 || grid[i][j] == 1) {
                    continue;
                }
                bfs(grid, i, j);
                int sum = 0;
                int nums = 0;
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < n; l++) {
                        if (grid[k][l] == 1) {
                            sum += distance[k][l];
                            nums++;
                        }
                    }
                }
                //不能到达全部建筑物
                if (num < nums) {
                    continue;
                } else {
                    if (minSum == -1) {
                        minSum = sum;
                    }
                    if (sum < minSum) {
                        minSum = sum;
                    }
                }
            }
        }
        return minSum;
    }

    void bfs(int[][] grid, int i, int j) {
        num = 0;
        int m = grid.length;
        int n = grid[0].length;
        distance = new int[m][n];
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                distance[k][l] = -1;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        distance[i][j] = 0;
        if (grid[i][j] == 1) {
            num++;
        }
        while (!queue.isEmpty()) {
            i = queue.peek()[0];
            j = queue.peek()[1];
            for (int k = 0; k < nextMove.length; k++) {
                int i2 = i + nextMove[k][0];
                int j2 = j + nextMove[k][1];
                //这个节点没有越界并且没有访问过 distance[i][j] = -1
                if (i2 >= 0 && i2 < m && j2 >= 0 && j2 < n && distance[i2][j2] == -1) {
                    //这个节点无法访问，跳过
                    if (grid[i2][j2] == 2) {
                        continue;
                    }
                    else {
                        //更新节点的距离
                        distance[i2][j2] = distance[i][j] + 1;
                        if (grid[i2][j2] == 1) {
                            num++;
                        } else {
                            queue.add(new int[]{i2, j2});
                        }
                    }
                }
            }
            queue.poll();
        }
    }
}
