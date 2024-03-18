package solution

import "math"

// NumSquares dp[i] 表示i最少由多少个平方数组成, dp[i]= min(dp[i-1],dp[i-2*2],dp[i-3*3]...)+1
func NumSquares(n int) int {
	g := make([]int, n+1)

	g[1] = 1

	for i := 2; i <= n; i++ {
		min := math.MaxInt
		for j := int(math.Sqrt(float64(i))); j >= 1; j-- {
			if g[i-j*j] < min {
				min = g[i-j*j]
			}
		}
		g[i] = min + 1
	}

	return g[n]
}
