package solution

func OddCells(m int, n int, indices [][]int) int {
	nums := make([][]int, m)
	for i := range nums {
		nums[i] = make([]int, n)
	}

	for i := 0; i < len(indices); i++ {
		m1 := indices[i][0]
		n1 := indices[i][1]
		for j := 0; j < n; j++ {
			nums[m1][j] += 1
		}
		for k := 0; k < m; k++ {
			nums[k][n1] += 1
		}
	}

	count := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if nums[i][j]%2 == 1 {
				count++
			}
		}
	}
	return count
}
