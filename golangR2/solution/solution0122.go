package solution

func MaxProfit(prices []int) int {
	res := 0
	length := len(prices)

	for i := 0; i < length-1; i++ {
		j := i + 1
		if prices[j]-prices[i] > 0 {
			res += prices[j] - prices[i]
		}
	}

	return res
}
