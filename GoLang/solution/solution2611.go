package solution

import "sort"

func MiceAndCheese(reward1 []int, reward2 []int, k int) int {
	sum := 0
	for _, v := range reward2 {
		sum += v
	}
	sub := make([]int, len(reward1))
	for i := 0; i < len(reward1); i++ {
		sub[i] = reward1[i] - reward2[i]
	}
	sort.Sort(sort.Reverse(sort.IntSlice(sub)))
	for i := 0; i < k; i++ {
		sum += sub[i]
	}
	return sum
}
