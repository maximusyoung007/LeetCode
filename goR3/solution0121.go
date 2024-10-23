package main

func MaxProfit(prices []int) int {
	n := len(prices)
	buy := make([]int, n)
	sell := make([]int, n)

	//buy表示截至到第i天买入的最小值
	//sell表示第i天卖出可以卖多少钱，等于当天卖出的价格减去前一天买入的最小值
	buy[0] = prices[0]
	sell[0] = 0

	res := 0

	for i := 1; i < n; i++ {
		if prices[i] < buy[i-1] {
			buy[i] = prices[i]
		} else {
			buy[i] = buy[i-1]
		}
		sell[i] = prices[i] - buy[i-1]
		if res < sell[i] {
			res = sell[i]
		}
	}

	return res
}