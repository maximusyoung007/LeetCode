package solution

import "math"

// UpdateMatrix g[i][j]表示各个位置到0的距离，如果这个位置是0，则g[i][j]=0,否则，是周围四个方向的g+1的最小值，
// 即 g[i][j] = min(g[i-1][j],g[i][j-1],g[i+1][j],g[i][j+1])+1
// 先从左上往右下遍历，判断左上方距离最近的0，再从右下往左上遍历，判断右下方距离最近的0；比较左上方的0和右下方的0哪个是最小值
func UpdateMatrix(mat [][]int) [][]int {
	m, n := len(mat), len(mat[0])

	g := make([][]int, m)
	for i := 0; i < m; i++ {
		g[i] = make([]int, n)
	}

	//默认为最大值，-1防止溢出
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			g[i][j] = math.MaxInt - 1
		}
	}

	//从左上往右下
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if mat[i][j] == 0 {
				g[i][j] = 0
			} else {
				if i > 0 {
					g[i][j] = getMin(g[i][j], g[i-1][j]+1)
				}
				if j > 0 {
					g[i][j] = getMin(g[i][j], g[i][j-1]+1)
				}
			}
		}
	}

	//从右下往左上遍历
	for i := m - 1; i >= 0; i-- {
		for j := n - 1; j >= 0; j-- {
			//mat[i][j] = 0的情况已经讨论过
			if mat[i][j] != 0 {
				if i < m-1 {
					g[i][j] = getMin(g[i][j], g[i+1][j]+1)
				}
				if j < n-1 {
					g[i][j] = getMin(g[i][j], g[i][j+1]+1)
				}
			}

		}
	}

	return g
}

func getMin(a int, b int) int {
	if a < b {
		return a
	}
	return b
}
