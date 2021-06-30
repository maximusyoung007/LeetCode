/**
 * 想象一下炸弹人游戏，在你面前有一个二维的网格来表示地图，网格中的格子分别被以下三种符号占据：
 *
 * 'W' 表示一堵墙
 * 'E' 表示一个敌人
 * '0'（数字 0）表示一个空位
 *
 * 请你计算一个炸弹最多能炸多少敌人。
 *
 * 由于炸弹的威力不足以穿透墙体，炸弹只能炸到同一行和同一列没被墙体挡住的敌人。
 *
 * 注意：你只能把炸弹放在一个空的格子里
 *
 * 示例:
 *
 * 输入: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
 * 输出: 3
 * 解释: 对于如下网格
 *
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 *
 * 假如在位置 (1,1) 放置炸弹的话，可以炸到 3 个敌人
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bomb-enemy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0361 {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] booms = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                booms[i][j] = 0;
            }
        }
        int boom;
        for (int i = 0; i < m; i++) {
            boom = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    boom = 0;
                } else if (grid[i][j] == 'E') {
                    boom += 1;
                }
                booms[i][j] += boom;
            }
            boom = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    boom = 0;
                } else if (grid[i][j] == 'E') {
                    boom += 1;
                }
                booms[i][j] += boom;
            }
        }

        for (int i = 0; i < n; i++) {
            boom = 0;
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 'W') {
                    boom = 0;
                } else if (grid[j][i] == 'E') {
                    boom += 1;
                }
                booms[j][i] += boom;
            }

            boom = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (grid[j][i] == 'W') {
                    boom = 0;
                } else if (grid[j][i] == 'E') {
                    boom += 1;
                }
                booms[j][i] += boom;
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0' && booms[i][j] > result) {
                    result = booms[i][j];
                }
            }
        }
        return result;
    }
}
