package solution

func NumberOfPairs(nums []int) []int {
	m := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		_, ok := m[nums[i]]
		if ok {
			m[nums[i]] = m[nums[i]] + 1
		} else {
			m[nums[i]] = 1
		}
	}
	res := []int{0, 0}
	for _, v := range m {
		if v%2 == 0 {
			res[0] = res[0] + v/2
		} else {
			res[0] = res[0] + (v-1)/2
			res[1] = res[1] + 1
		}
	}
	return res
}
