package solution

import (
	"fmt"
)

func minSubarray(nums []int, p int) int {
	x := 0
	for _, num := range nums {
		x = (x + num) % p
	}
	if x == 0 {
		return 0
	}
	index := make(map[int]int)
	y, res := 0, len(nums)
	for i := 0; i < len(nums); i++ {
		index[y] = i
		y = (y + nums[i]) % p
		_, ok := index[(y-x+p)%p]
		if ok {
			if i-index[(y-x+p)%p]+1 < res {
				res = i - index[(y-x+p)%p] + 1
			}
		}
	}
	if res == len(nums) {
		res = -1
	}
	return res
}

func Test1590() {
	//nums := []int{3, 1, 4, 2}
	//p := 6
	//nums := []int{6, 3, 5, 2}
	//p := 9
	//nums := []int{1, 2, 3}
	//p := 7
	//nums := []int{9, 10, 1, 2, 9, 16, 1, 2}
	//p := 6
	nums := []int{8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4, 2}
	p := 148
	fmt.Println(minSubarray(nums, p))
}
