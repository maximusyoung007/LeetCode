package solution

import (
	"container/heap"
	"fmt"
)

func kthSmallest(matrix [][]int, k int) int {
	ish := &indexSmallHeap{}
	index := make([]int, len(matrix))
	heap.Init(&indexSmallHeap{})
	for i := 0; i < len(matrix); i++ {
		index[i] = 0
		heap.Push(ish, indexNum{i, matrix[i][0]})
	}
	var t indexNum
	for k > 0 && ish.Len() > 0 {
		t = heap.Pop(ish).(indexNum)
		if index[t.i] < len(matrix[t.i])-1 {
			index[t.i] += 1
			heap.Push(ish, indexNum{t.i, matrix[t.i][index[t.i]]})
		}
		k--
	}
	return t.num
}

type indexNum struct {
	i, num int
}

type indexSmallHeap []indexNum

func (h indexSmallHeap) Len() int {
	return len(h)
}

func (h indexSmallHeap) Less(i, j int) bool {
	return h[i].num < h[j].num
}

func (h indexSmallHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *indexSmallHeap) Push(x any) {
	*h = append(*h, x.(indexNum))
}

func (h *indexSmallHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func Test0378() {
	//matrix := [][]int{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}
	//k := 8
	matrix := [][]int{{-5}}
	k := 1
	fmt.Println(kthSmallest(matrix, k))
}
