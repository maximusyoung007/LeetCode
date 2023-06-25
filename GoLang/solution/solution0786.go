package solution

import (
	"container/heap"
	"fmt"
)

func kthSmallestPrimeFraction(arr []int, k int) []int {
	fsh := &fractionHeap{}
	heap.Init(fsh)
	for i := len(arr) - 1; i >= 1; i-- {
		ft := fraction{0, i, float64(arr[0]) / float64(arr[i])}
		heap.Push(fsh, ft)
	}
	var t fraction
	for k > 0 && fsh.Len() > 0 {
		t = heap.Pop(fsh).(fraction)
		k--
		if t.i+1 < t.j {
			ft := fraction{t.i + 1, t.j, float64(arr[t.i+1]) / float64(arr[t.j])}
			heap.Push(fsh, ft)
		}
	}
	return []int{arr[t.i], arr[t.j]}
}

type fraction struct {
	i, j     int
	fraction float64
}

type fractionHeap []fraction

func (h fractionHeap) Len() int {
	return len(h)
}

func (h fractionHeap) Less(i, j int) bool {
	return h[i].fraction < h[j].fraction
}

func (h fractionHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *fractionHeap) Push(x interface{}) {
	*h = append(*h, x.(fraction))
}

func (h *fractionHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func Test0786() {
	//arr := []int{1, 2, 3, 5}
	//k := 3
	arr := []int{1, 7}
	k := 1
	fmt.Println(kthSmallestPrimeFraction(arr, k))
}
