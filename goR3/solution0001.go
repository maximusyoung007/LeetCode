package main

func TwoSum0001(nums []int, target int) []int {
	m := make(map[int]int)

	for i, num := range nums {
		_, ok := m[target-num]
		if ok {
			return []int {i, m[target-num]}
		} else {
			m[num] = i
		}
	}

	return []int{}
}