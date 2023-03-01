package solution

func LargestLocal(grid [][]int) [][]int {
	n := len(grid)
	res := make([][]int, n-2)
	for i := 0; i < len(res); i++ {
		res[i] = make([]int, n-2)
	}
	var max int
	for i := 0; i < n-2; i++ {
		for j := 0; j < n-2; j++ {
			max = 0
			for k := i; k <= i+2; k++ {
				for l := j; l <= j+2; l++ {
					if grid[k][l] > max {
						max = grid[k][l]
					}
				}
			}
			res[i][j] = max
		}
	}
	return res
}
