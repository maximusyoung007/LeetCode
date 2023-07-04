package solution

import (
	"fmt"
	"sort"
)

func matrixSum(nums [][]int) int {
	for _, v := range nums {
		sort.Ints(v)
	}

	res := 0
	for j := 0; j < len(nums[0]); j++ {
		max := 0
		for i := 0; i < len(nums); i++ {
			if nums[i][j] > max {
				max = nums[i][j]
			}
		}
		res += max
	}
	return res
}

func Test2679() {
	//7 2 1
	//6 4 2
	//6 5 3
	//3 2 1
	nums := [][]int{{7, 2, 1}, {6, 4, 2}, {6, 5, 3}, {3, 2, 1}}
	fmt.Println(matrixSum(nums))
}
