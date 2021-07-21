/**
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * 提示：
 *
 * 0 <= k <= 100
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 买入：
 * 一种是前一天已经第j次购买，对应于前一天的buy[j]；
 * 一种是前一天已经第j-1次卖出，第i天买入，对应于前一天的sell[j-1]减去当天的价格prices[i]。
 * 卖出：
 * 一种是前一天已经第j次卖出，对应于前一天的sell[j]；
 * 一种是前一天已经第j次买入，第i天卖出，对应于前一天的buy[j]加上当天的价格prices[i]
 *
 */
public class Solution0188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1 || k == 0) {
            return 0;
        }
        //一次交易包含一次买入和一次卖出,大于n/2的交易无法完成
        k = Math.min(k, n / 2);
        int[] buys = new int[k];
        int[] sells = new int[k];
        //第1天买入卖出i次
        for (int i = 0; i < k; i++) {
            buys[i] = -prices[0];
            sells[i] = 0;
        }

        //第i天买入卖出j次
        for (int i = 1; i < n; i++) {
            buys[0] = Math.max(buys[0], -prices[i]);
            sells[0] = Math.max(sells[0], buys[0] + prices[i]);
            for (int j = k - 1; j > 0; j--) {
                buys[j] = Math.max(buys[j], sells[j - 1] - prices[i]);
                //如果前一天是第j次购买，当天则不再购买，因此当天的buys[j]必定等于前一天的buys[j],
                // 当天的卖出等于前一天的购买加当天的股价，即buys[j] + prices[i]
                sells[j] = Math.max(sells[j], buys[j] + prices[i]);
            }
        }
        return sells[k - 1];
    }
}
