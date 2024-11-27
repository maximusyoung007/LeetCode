package main

func LongestConsecutive(nums []int) int {
	m := make(map[int]int)

	for i := range nums {
		m[nums[i]] = 1
	}

	res := 0

	for key, _ := range m {
		_, ok := m[key-1]
		ts := 1
		v := key + 1
		if !ok {
			_, ok1 := m[v]
			for ok1 {
				ts++
				v++
				_, ok1 = m[v]
			}
		}

		if ts > res {
			res = ts
		}
	}

	return res
}
