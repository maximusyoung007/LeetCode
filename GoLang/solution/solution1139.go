package solution

/*
*
思路：(i,j)表示某个正方形的右下顶点，dp[i][j][0]表示横向连续1的个数，dp[i][j][1]表示纵向连续1的个数
dp[i][j][0]和dp[i][j][1]比较小的那个，表示以(i,j)为右下顶点的可能存在的正方形的变长
设变长为len，
再判断右上顶点横向连续1的个数和左下顶点纵向连续1的个数是否大于等于len,如果是的，则len满足条件
否则，len-1继续判断。
但是len始终要大于当前max，否则就没有意义了(max为当下最大正方形变长)
动态规划的特点就是一看就懂了，一写就懵逼
*/
func Largest1BorderedSquare(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	dp := make([][][]int, m+1)
	for i := range dp {
		dp[i] = make([][]int, n+1)
		for j := range dp[i] {
			dp[i][j] = make([]int, 2)
		}
	}
	dp[0][0][0], dp[0][0][1] = 0, 0
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if grid[i-1][j-1] == 1 {
				dp[i][j][0] = dp[i][j-1][0] + 1
				dp[i][j][1] = dp[i-1][j][1] + 1
			}
		}
	}

	res := 0
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if grid[i-1][j-1] == 0 {
				continue
			} else {
				var min int
				if dp[i][j][0] > dp[i][j][1] {
					min = dp[i][j][1]
				} else {
					min = dp[i][j][0]
				}
				if res < min {
					for res < min && (dp[i][j-min+1][1] < min || dp[i-min+1][j][0] < min) {
						min--
					}
					res = min
				}
			}
		}
	}
	return res * res
}
