package solution

func MaxValue(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
	}

	dp[0][0] = grid[0][0]
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if i == 0 && j == 0 {
				continue
			} else {
				if i-1 >= 0 && j-1 >= 0 {
					dp[i][j] = maxChoice(dp[i-1][j], dp[i][j-1]) + grid[i][j]
				} else if i-1 >= 0 && j == 0 {
					dp[i][j] = dp[i-1][j] + grid[i][j]
				} else if i == 0 && j-1 >= 0 {
					dp[i][j] = dp[i][j-1] + grid[i][j]
				}
			}
		}
	}

	return dp[m-1][n-1]
}

func maxChoice(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
