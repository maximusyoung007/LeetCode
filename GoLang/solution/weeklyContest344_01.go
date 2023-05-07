package solution

func DistinctDifferenceArray(nums []int) []int {
	res := make([]int, len(nums))
	partNum1 := make([]int, 0)
	partNum2 := make([]int, 0)
	for i := 0; i < len(nums); i++ {
		if i == 0 {
			partNum1 = append(partNum1, nums[0])
			partNum2 = nums[1:]
		} else {
			partNum1 = append(partNum1, partNum2[0])
			partNum2 = partNum2[1:]
		}
		diff1 := calDiff(partNum1)
		diff2 := calDiff(partNum2)
		res[i] = diff1 - diff2
	}
	return res
}

func calDiff(nums []int) int {
	count := 0
	m := make(map[int]int, 0)
	for i := 0; i < len(nums); i++ {
		_, ok := m[nums[i]]
		//如果不存在就+1
		if !ok {
			m[nums[i]] = 1
			count++
		}
	}
	return count
}
