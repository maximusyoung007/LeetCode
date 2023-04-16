package solution

func RowAndMaximumOnes(mat [][]int) []int {
	res := make([]int, 2)
	count := 0
	for i := 0; i < len(mat); i++ {
		c := 0
		for j := 0; j < len(mat[i]); j++ {
			if mat[i][j] == 1 {
				c++
			}
		}
		if c > count {
			count = c
			res[0] = i
			res[1] = c
		}
	}
	return res
}
