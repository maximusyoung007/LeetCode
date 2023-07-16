package solution

import (
	"fmt"
	"sort"
)

func maximumBeauty(nums []int, k int) int {
	//res := 0
	//type pair35402 struct {
	//	start, end int
	//}
	//ra := make([]pair35402, 0)
	//sort.Ints(nums)
	//for i := 0; i < len(nums); i++ {
	//for j := nums[i] - k; j <= nums[i]+k; j++ {
	//	m[j]++
	//	if m[j] > res {
	//		res = m[j]
	//	}
	//}
	//if res == len(nums) {
	//	break
	//}
	//	start := nums[i] - k
	//	end := nums[i] + k
	//	ra = append(ra, pair35402{start, end})
	//}
	//
	//s, e := math.MinInt, math.MaxInt
	//t := 0
	//for _, r := range ra {
	//	if r.start > e && r.end > s {
	//		t = 1
	//	} else {
	//		if r.start >= s {
	//			s = r.start
	//		}
	//		if r.end <= e {
	//			e = r.end
	//		}
	//		t++
	//		if t > res {
	//			res = t
	//		}
	//	}
	//}
	//
	//return res
	left, res := 0, 0
	sort.Ints(nums)
	for i := 0; i < len(nums); i++ {
		for nums[i]-nums[left] > 2*k {
			left++
		}
		if i-left+1 > res {
			res = i - left + 1
		}
	}
	return res
}

func Test35402() {
	//nums := []int{27, 55}
	nums := []int{4, 6, 1, 2}
	//nums := []int{1, 1, 1, 1}
	fmt.Println(maximumBeauty(nums, 2))
}
