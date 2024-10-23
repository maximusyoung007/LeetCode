package main

func maxProfit2(prices []int) int {
    n := len(prices)
	
	//dp[i][0]表示第i天结束时手上没有股票的最大利润
	//dp[i][1]表示第i天结束时手上有股票的最大利润
	//dp[i][0]，当天手上没有股票，可能是昨天手上没有股票，今天没有买也没有卖；也可能是昨天手上有股票，今天卖了，即
	//dp[i][0] = max {dp[i-1][0], dp[i-1][1] + prices[i]}
	//dp[i][1], 表示当天手上有股票，可能是昨天手上有股票，今天没有买也没有卖；也可能是昨天手上没股票，今天买了， 即
	//dp[i][1] = max {dp[i-1][1], dp[i-1][0] - prices[i]}
	dp := make([][]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, 2)
	}

	dp[0][0] = 0
	dp[0][1] = -prices[0]

	for i := 1; i < n; i++ {
		if dp[i-1][1] + prices[i] > dp[i-1][0] {
			dp[i][0] = dp[i-1][1] + prices[i]
		} else {
			dp[i][0] = dp[i-1][0]
		}
	}

}