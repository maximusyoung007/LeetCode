package solution

import (
	"math"
	"sort"
)

func MinimumAbsDifference(arr []int) [][]int {
	sort.Ints(arr)
	var result [][]int

	min := math.MaxInt32
	for i, j := 0, 1; j < len(arr); i, j = i+1, j+1 {
		if arr[j]-arr[i] <= min {
			if arr[j]-arr[i] < min && len(result) != 0 {
				result = [][]int{}
			}
			min = arr[j] - arr[i]
			ps := []int{arr[i], arr[j]}
			result = append(result, ps)
		}
	}
	return result
}
