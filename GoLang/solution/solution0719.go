package solution

import (
	"fmt"
	"sort"
)

/*
*
对nums排序，先保存(0,1),(1,2),(2,3)...(n-2,n-1)
即统计以0，1，2，3...n-1开头的数对
假设(1,2)最小，出堆，并将（1，3）入堆
依此类推
*/
func smallestDistancePair(nums []int, k int) int {
	//sort.Ints(nums)
	//sh := &subHeap{}
	//heap.Init(sh)
	//for i := 0; i < len(nums)-1; i++ {
	//	sc := subCompare{i, i + 1, int(math.Abs(float64(nums[i] - nums[i+1])))}
	//	heap.Push(sh, sc)
	//}
	//res := 0
	//for k > 0 && sh.Len() > 0 {
	//	k--
	//	t := heap.Pop(sh).(subCompare)
	//	res = t.sub
	//	if t.j+1 < len(nums) {
	//		st := subCompare{t.i, t.j + 1, int(math.Abs(float64(nums[t.j+1] - nums[t.i])))}
	//		heap.Push(sh, st)
	//	}
	//}
	//return res
	n := len(nums)
	sort.Ints(nums)
	l, r := 0, nums[n-1]-nums[0]
	for l < r {
		m := (l + r) / 2
		if countK(m, nums) >= k {
			r = m
		} else {
			l = m + 1
		}
	}
	return l
}

func countK(k int, nums []int) int {
	cnt, l, n := 0, 0, len(nums)
	for r := 0; r < n; r++ {
		for l < r && nums[r]-nums[l] > k {
			l++
		}
		cnt += r - l
	}
	return cnt
}

//小根堆超时
//type subCompare struct {
//	i, j, sub int
//}
//
//type subHeap []subCompare
//
//func (h subHeap) Len() int {
//	return len(h)
//}
//
//func (h subHeap) Less(i, j int) bool {
//	return h[i].sub < h[j].sub
//}
//
//func (h subHeap) Swap(i, j int) {
//	h[i], h[j] = h[j], h[i]
//}
//
//func (h *subHeap) Push(x interface{}) {
//	*h = append(*h, x.(subCompare))
//}
//
//func (h *subHeap) Pop() interface{} {
//	old := *h
//	n := len(old)
//	x := old[n-1]
//	*h = old[0 : n-1]
//	return x
//}

func Test0719() {
	//nums := []int{1, 3, 1}
	//k := 1
	//nums := []int{1, 6, 1}
	//k := 3
	nums := []int{1, 1, 1}
	k := 2
	//nums := []int{9, 10, 7, 10, 6, 1, 5, 4, 9, 8}
	//k := 18
	fmt.Println(smallestDistancePair(nums, k))
}
