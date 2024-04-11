public class Solution0714 {
	public int maxProfit(int[] prices, int fee) {
		int n = prices.length;

		int have = -prices[0];
		int notHave = 0;

		for (int i = 1; i < n; i++) {
			have = Math.max(have, notHave - prices[i]);
			notHave = Math.max(notHave, have + prices[i] - fee);
		}

		return notHave;
	}
}
