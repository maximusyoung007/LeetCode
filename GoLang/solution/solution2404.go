package solution

func MostFrequentEven(nums []int) int {
	m := make(map[int]int, 0)
	for _, v := range nums {
		if v%2 == 0 {
			m[v]++
		}
	}
	max := -1
	maxIndex := -1
	for k, v := range m {
		if v > max {
			max = v
			maxIndex = k
		}
		if v == max {
			if k < maxIndex {
				max = v
				maxIndex = k
			}
		}
	}
	return maxIndex
}
