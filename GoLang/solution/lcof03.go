package solution

func FindRepeatNumber(nums []int) int {
	var m map[int]int
	m = make(map[int]int)
	r := -1
	for i := 0; i < len(nums); i++ {
		_, ok := m[nums[i]]
		if ok {
			r = nums[i]
			break;
		} else {
			m[nums[i]] = 1
		}
	}
	return r
}