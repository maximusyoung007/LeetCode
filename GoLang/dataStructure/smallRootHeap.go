package datastructure

type SmallRootHeap []int

func (h SmallRootHeap) Len() int {
	return len(h)
}

func (h SmallRootHeap) Less(i, j int) bool {
	return h[i] < h[j]
}

func (h SmallRootHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *SmallRootHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *SmallRootHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}
