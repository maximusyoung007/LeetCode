/**
 *一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 *
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 *
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 *
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * -2(k) -3  3
 * -5    -10 1
 * 10    30  -5(p)
 *  
 *
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 *
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 *
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 *  
 *
 * 说明:
 *
 * 骑士的健康点数没有上限。
 *
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dungeon-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        //表示在每个点活下来至少需要多少血
        int[][] pointMin = new int[m][n];
        if (dungeon[m - 1][n - 1] <= 0) {
            pointMin[m - 1][n - 1] = -dungeon[m -1][n - 1] + 1;
        } else {
            pointMin[m - 1][n - 1] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;
                int min1 = Integer.MIN_VALUE, min2 = Integer.MAX_VALUE;
                if (i + 1 < m) {
                    if (dungeon[i][j] < pointMin[i + 1][j]) {
                        min1 = pointMin[i + 1][j] - dungeon[i][j];
                    } else {
                        min1 = 1;
                    }
                }
                if (j + 1 < n) {
                    if (dungeon[i][j] < pointMin[i][j + 1]) {
                        min2 = pointMin[i][j + 1] - dungeon[i][j];
                    } else {
                        min2 = 1;
                    }
                }
                if (min1 != Integer.MIN_VALUE && min2 != Integer.MIN_VALUE) {
                    pointMin[i][j] = Math.min(min1, min2);
                } else if (min1 != Integer.MIN_VALUE) {
                    pointMin[i][j] = min1;
                } else if (min2 != Integer.MIN_VALUE) {
                    pointMin[i][j] = min2;
                }
            }
        }
        return pointMin[0][0];
    }
}