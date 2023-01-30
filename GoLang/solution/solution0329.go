package solution

var next = [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}

func LongestIncreasingPath(matrix [][]int) int {
	res := 0
	m := len(matrix)
	n := len(matrix[0])
	count := make([][]int, m)
	for i := 0; i < m; i++ {
		count[i] = make([]int, n)
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			counts := dfs(count, i, j, m, n, matrix)
			if counts > res {
				res = counts
			}
		}
	}
	return res
}

func dfs(count [][]int, i int, j int, m int, n int, matrix [][]int) int {
	if count[i][j] != 0 {
		return count[i][j]
	}
	count[i][j] = 1
	for c := 0; c < len(next); c++ {
		i1 := i + next[c][0]
		j1 := j + next[c][1]
		if i1 >= 0 && i1 < m && j1 >= 0 && j1 < n && matrix[i1][j1] > matrix[i][j] {
			counts := dfs(count, i1, j1, m, n, matrix) + 1
			if counts > count[i][j] {
				count[i][j] = counts
			}
		}
	}
	return count[i][j]
}
