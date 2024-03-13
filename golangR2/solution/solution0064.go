package solution

// MinPathSum g[i][j]表示到i,j位置的最小步数，这一定是从上边或者左边移动过来的，g[i][j]=min(g[i-1][j],g[i][j-1)+grid[i][j]
func MinPathSum(grid [][]int) int {
	m, n := len(grid), len(grid[0])

	g := make([][]int, m)

	for i := 0; i < len(grid); i++ {
		g[i] = make([]int, n)
	}

	g[0][0] = grid[0][0]

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			preMin := 0

			if i == 0 && j == 0 {
				continue
			}

			if i == 0 {
				preMin = g[i][j-1]
			} else if j == 0 {
				preMin = g[i-1][j]
			} else {
				if g[i-1][j] > g[i][j-1] {
					preMin = g[i][j-1]
				} else {
					preMin = g[i-1][j]
				}
			}
			g[i][j] = preMin + grid[i][j]
		}
	}

	return g[m-1][n-1]
}
