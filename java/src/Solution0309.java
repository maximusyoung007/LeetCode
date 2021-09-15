/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        //dp表示当天操作之后，后一天的状态
        //持有股票
        dp[0][0] = -prices[0];
        //不持有股票，不处于冷冻期
        dp[0][1] = 0;
        //不持有股票，处于冷冻期
        dp[0][2] = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            //前一天持有股票 前一天不持有股票，不处于冷冻期，今天买入股票
            dp[i][0] = Integer.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            //不持有股票 没有买入 不处于冷冻期 没有卖出 当天什么都没有做
            dp[i][1] = Integer.max(dp[i - 1][1], dp[i - 1][2]);
            //不持有股票 没有买入 处于冷冻期 今天卖出
            dp[i][2] = dp[i - 1][0] + prices[i];
        }
        return Integer.max(dp[n - 1][1], dp[n - 1][2]);
    }
}
