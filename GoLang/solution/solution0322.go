package solution

//dfs 又超时咧 还不会优化咧
//func CoinChange(coins []int, amount int) int {
//	sum, count := 0, 0
//	if amount == 0 {
//		return 0
//	}
//
//	coinSum := math.MaxInt
//	dfsCoins(coins, sum, amount, count, &coinSum)
//	if coinSum == math.MaxInt {
//		coinSum = -1
//	}
//	return coinSum
//}
//
//func dfsCoins(coins []int, sum int, amount int, count int, coinsSum *int){
//	if sum == amount {
//		*coinsSum = count
//	}
//	for i := len(coins) - 1; i >= 0; i-- {
//		sum += coins[i]
//		if sum > amount {
//			sum -= coins[i]
//			continue
//		}
//		count++
//		if count >= *coinsSum {
//			count--
//			continue
//		}
//		dfsCoins(coins, sum, amount, count, coinsSum)
//		count--
//		sum -= coins[i]
//	}
//}

//动态规划
/**
dp[n]表示达到n需要的最小的个数
n == 0
dp[0]=0
n > 0
dp[n] = min(dp[n-coin]+1)
*/
func CoinChange(coins []int, amount int) int {
	if amount == 0 {
		return 0
	}
	n := len(coins)
	dp := make([]int, amount+1)
	for i := 1; i <= amount; i++ {
		for j := 0; j < n; j++ {
			if i-coins[j] >= 0 {
				t := dp[i-coins[j]] + 1
				//上一个dp为dp[0]或者dp存在
				if (dp[i-coins[j]] == 0 && i-coins[j] == 0) || (dp[i-coins[j]] != 0 && i-coins[j] != 0) {
					if dp[i] == 0 {
						dp[i] = t
					}
					if dp[i] != 0 && t < dp[i] {
						dp[i] = t
					}
				}
			}
		}
	}
	if dp[amount] == 0 {
		return -1
	}
	return dp[amount]
}
