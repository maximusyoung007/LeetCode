package solution

func ConstructArray(n int, k int) []int {
	answer := make([]int, n)
	idx := 0
	//前n-k个有一种结果
	for i := 1; i < n-k; i++ {
		answer[idx] = i
		idx++
	}
	//后k个有k-1种结果
	for i, j := n-k, n; i <= j; i, j = i+1, j-1 {
		answer[idx] = i
		idx++
		if i != j {
			answer[idx] = j
			idx++
		}
	}
	return answer
}
