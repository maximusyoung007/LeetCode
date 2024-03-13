package solution

import (
	"math"
)

// g[i][j]表示以i，j为右下角节点的最大正方形，若满足，则g[i-1][j]、g[i][j-1]、g[i-1][j-1]的最小值应该=g[i][j]-1
func MaximalSquare(matrix [][]byte) int {
	m, n := len(matrix), len(matrix[0])

	g := make([][]int, m)
	for i := 0; i < m; i++ {
		g[i] = make([]int, n)
	}

	maxValue := 0

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if matrix[i][j] == '0' {
				g[i][j] = 0
			} else {
				minValue := getMinValue(i, j, g)
				g[i][j] = minValue + 1
			}

			if g[i][j] > maxValue {
				maxValue = g[i][j]
			}
		}
	}
	return maxValue * maxValue
}

func getMinValue(i int, j int, g [][]int) int {
	if i-1 < 0 || j-1 < 0 {
		return 0
	}

	return int(math.Min(math.Min(float64(g[i-1][j]), float64(g[i][j-1])), float64(g[i-1][j-1])))
}
