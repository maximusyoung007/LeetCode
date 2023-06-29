package solution

import "fmt"

func reconstructMatrix(upper int, lower int, colsum []int) [][]int {
	pa, pb := make([]int, len(colsum)), make([]int, len(colsum))
	for i := 0; i < len(pa); i++ {
		if colsum[i] == 2 {
			pa[i] = 1
			pb[i] = 1
			upper--
			lower--
		} else if colsum[i] == 1 {
			if upper > lower {
				pa[i] = 1
				upper--
			} else {
				pb[i] = 1
				lower--
			}
		} else {
			pa[i] = 0
			pb[i] = 0
		}
	}
	res := make([][]int, 2)
	if upper != 0 || lower != 0 {
		return [][]int{}
	}
	res[0] = pa
	res[1] = pb
	return res
}

func Test1253() {
	upper, lower := 2, 1
	colSum := []int{1, 1, 1}
	//upper, lower := 2, 3
	//colSum := []int{2, 2, 1, 1}
	//upper, lower := 5, 5
	//colSum := []int{2, 1, 2, 0, 1, 0, 1, 2, 0, 1}
	//upper, lower := 4, 7
	//colSum := []int{2, 1, 2, 2, 1, 1, 1}
	fmt.Println(reconstructMatrix(upper, lower, colSum))
}
