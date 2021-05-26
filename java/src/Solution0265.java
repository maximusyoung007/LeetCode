/**
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成 k 种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x k 的矩阵来表示的。
 *
 * 例如，costs[0][0] 表示第 0 号房子粉刷成 0 号颜色的成本花费；costs[1][2] 表示第 1 号房子粉刷成 2 号颜色的成本花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。
 * 注意：
 * 所有花费均为正整数。
 * 示例：
 * 输入: [[1,5,3],[2,9,4]]
 * 输出: 5
 * 解释: 将 0 号房子粉刷成 0 号颜色，1 号房子粉刷成 2 号颜色。最少花费: 1 + 4 = 5;
 *      或者将 0 号房子粉刷成 2 号颜色，1 号房子粉刷成 0 号颜色。最少花费: 3 + 2 = 5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paint-house-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0265 {
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        int minCost = Integer.MAX_VALUE;
        int minCost2 = Integer.MAX_VALUE;
        int minCostIndex = 0;
        int preMinCost = Integer.MAX_VALUE;
        int preMinCost2 = Integer.MAX_VALUE;
        int preMinIndex = 0;
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
            if (dp[0][i] < minCost) {
                minCost2 = minCost;
                minCost = dp[0][i];
                minCostIndex = i;
            } else if (dp[0][i] < minCost2) {
                minCost2 = dp[0][i];
            }
            preMinCost = minCost;
            preMinCost2 = minCost2;
            preMinIndex = minCostIndex;
        }
        for (int i = 1; i < n; i++) {
            minCost = Integer.MAX_VALUE;
            minCost2 = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (j != preMinIndex) {
                    dp[i][j] = preMinCost + costs[i][j];
                } else {
                    dp[i][j] = preMinCost2 + costs[i][j];
                }
                //计算本轮的minCost和minCost2
                if (dp[i][j] < minCost) {
                    minCost2 = minCost;
                    minCost = dp[i][j];
                    minCostIndex = j;
                } else if (dp[i][j] < minCost2) {
                    minCost2 = dp[i][j];
                }
            }
            preMinCost = minCost;
            preMinCost2 = minCost2;
            preMinIndex = minCostIndex;
        }
        return preMinCost;
    }
}
