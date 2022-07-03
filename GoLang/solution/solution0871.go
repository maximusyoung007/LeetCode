package solution

import (
	"container/heap"
)

type MaxHeap []int

func (h MaxHeap) Len() int           { return len(h) }
func (h MaxHeap) Less(i, j int) bool { return h[i] > h[j] }
func (h MaxHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *MaxHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *MaxHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func MinRefuelStops(target int, startFuel int, stations [][]int) int {
	result := 0
	length := 0
	h := &MaxHeap{}
	for i := 0; i <= len(stations); i++ {
		var d int
		if i != len(stations) {
			d = stations[i][0] - length
		} else {
			d = target - length
		}

		for startFuel < d && h.Len() != 0 {
			startFuel += heap.Pop(h).(int)
			result++
		}

		if startFuel < d && h.Len() == 0 {
			return -1
		}

		if i != len(stations) {
			startFuel -= d
			length += d
			heap.Push(h, stations[0][1])
		}
	}
	return result
}
