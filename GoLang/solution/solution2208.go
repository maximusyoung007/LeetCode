package solution

import (
	"container/heap"
	"fmt"
)

//优先队列，每次都取出队列中最大的并减半
func halveArray(nums []int) int {
	h := &halveHeap{}
	heap.Init(h)
	var ans1, ans2 float64
	ans1, ans2 = 0, 0
	for _, num := range nums {
		ans1 += float64(num)
		ans2 += float64(num)
		heap.Push(h, float64(num))
	}

	count := 0
	for ans1*2 > ans2 {
		t := heap.Pop(h).(float64)
		t /= 2
		ans1 -= t
		count++
		heap.Push(h, t)
	}
	return count
}

func Test2208() {
	//nums := []int{5, 19, 8, 1}
	nums := []int{3, 8, 10}
	fmt.Println(halveArray(nums))
}

type halveHeap []float64

func (h halveHeap) Len() int { return len(h) }

func (h halveHeap) Less(i, j int) bool { return h[i] > h[j] }

func (h halveHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i] }

func (h *halveHeap) Push(x interface{}) { *h = append(*h, x.(float64)) }

func (h *halveHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}
