package solution

import "sort"

func canBeEqual(target []int, arr []int) bool {
	len1, len2 := len(target), len(arr)
	if len1 != len2 {
		return false
	}
	sort.Ints(target)
	sort.Ints(arr)
	for i := 0; i < len1; i++ {
		if target[i] != arr[i] {
			return false
		}
	}
	return true
}
