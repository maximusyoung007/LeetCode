package solution

func TopKFrequent(nums []int, k int) []int {
	m := make(map[int]int, 0)

	maxIndex := 0

	//记录数字及频率
	for _, num := range nums {
		m[num]++
		if m[num] > maxIndex {
			maxIndex = m[num]
		}
	}

	t := make([][]int, maxIndex+1)
	for i := 0; i < maxIndex+1; i++ {
		t[i] = make([]int, 0)
	}

	//数组下标是频率，可能有多个，所以是个二维数组
	for k, v := range m {
		t[v] = append(t[v], k)
	}

	res := make([]int, 0)
	count := 0
	for i := len(t) - 1; i >= 0; i-- {
		for j := 0; j < len(t[i]); j++ {
			res = append(res, t[i][j])
			count++
			if count == k {
				goto returnRes
			}
		}
	}
returnRes:
	return res
}
