package solution

import (
	"container/heap"
	"fmt"
)

func rangeSum(nums []int, n int, left int, right int) int {
	left -= 1
	k := right - left
	sah := &smallArrHeap{}
	heap.Init(sah)
	for i := 0; i < len(nums); i++ {
		s := sub{i, i, nums[i]}
		heap.Push(sah, s)
	}
	res := 0
	//先推出前left个
	for left > 0 {
		t := heap.Pop(sah).(sub)
		if t.j+1 < len(nums) {
			t.j = t.j + 1
			t.s += nums[t.j]
			heap.Push(sah, t)
		}
		left--
	}
	//推出k个
	for k > 0 {
		t := heap.Pop(sah).(sub)
		res += t.s
		if t.j+1 < len(nums) {
			t.j = t.j + 1
			t.s += nums[t.j]
			heap.Push(sah, t)
		}
		k--
	}
	res = res % (1e9 + 7)
	return res
}

type sub struct {
	i, j, s int
}

type smallArrHeap []sub

func (h smallArrHeap) Len() int {
	return len(h)
}

func (h smallArrHeap) Less(i, j int) bool {
	return h[i].s < h[j].s
}

func (h smallArrHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *smallArrHeap) Push(x interface{}) {
	*h = append(*h, x.(sub))
}

func (h *smallArrHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func Test1508() {
	nums := []int{1, 2, 3, 4}
	n := 4
	left := 1
	right := 5
	//left := 1
	//right := 10
	fmt.Println(rangeSum(nums, n, left, right))
}
