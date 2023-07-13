package solution

import (
	"fmt"
	"math"
)

func minFallingPathSum(matrix [][]int) int {
	cal := make([][]int, len(matrix))
	res := math.MaxInt
	for i := 0; i < len(matrix); i++ {
		cal[i] = make([]int, len(matrix[0]))
		for j := 0; j < len(matrix[0]); j++ {
			cal[i][j] = matrix[i][j]
			if i != 0 {
				if j == 0 {
					cal[i][j] += smallestOfThree(cal[i-1][j], cal[i-1][j+1], math.MaxInt)
				} else if j == len(matrix[0])-1 {
					cal[i][j] += smallestOfThree(cal[i-1][j], cal[i-1][j-1], math.MaxInt)
				} else {
					cal[i][j] += smallestOfThree(cal[i-1][j], cal[i-1][j-1], cal[i-1][j+1])
				}
			}
			if i == len(matrix)-1 {
				if cal[i][j] < res {
					res = cal[i][j]
				}
			}
		}
	}

	return res
}

func smallestOfThree(a int, b int, c int) int {
	t := 0
	if a < b {
		t = a
	} else {
		t = b
	}

	if c < t {
		t = c
	}
	return t
}

func Test0931() {
	//matrix := [][]int{{-19, 57}, {-40, -5}}
	matrix := [][]int{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}
	fmt.Println(minFallingPathSum(matrix))
}
