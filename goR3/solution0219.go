package main

func ContainsNearbyDuplicate(nums []int, k int) bool {
	m := make(map[int][]int)

	for i := 0; i < len(nums); i++ {
		_, ok := m[nums[i]]
		if ok {
			t := m[nums[i]]
			if i-t[len(t)-1] <= k {
				return true
			} else {
				t = append(t, i)
				m[nums[i]] = t
			}
		} else {
			t := []int{i}
			m[nums[i]] = t
		}
	}

	return false
}
