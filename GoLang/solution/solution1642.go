package solution

import (
	"container/heap"
	"fmt"
	d "gproject/dataStructure"
)

/**
先用小根堆存储使用梯子的数量，当梯子用完，即小根堆的数量大于梯子的数量以后，出堆，把最小的梯子换成砖
继续向后遍历，每次遍历都把最小的梯子换成砖，直到下一轮最小的梯子大于剩余砖的个数
此时，i即为所求答案
*/
func FurthestBuilding(heights []int, bricks int, ladders int) int {
	h := &d.SmallRootHeap{}
	heap.Init(h)
	n := len(heights)
	i, j := 0, 1
	for ; j < n; i, j = i+1, j+1 {
		gap := heights[j] - heights[i]
		if gap > 0 {
			heap.Push(h, gap)
			if len(*h) > ladders {
				b := heap.Pop(h).(int)
				if bricks >= b {
					bricks -= b
				} else {
					break
				}
			}
		}
	}
	return i
}

func TestHeap() {
	h := &d.SmallRootHeap{2, 1, 5, 6, 4, 3, 7, 9, 8, 0}
	heap.Init(h)
	fmt.Println(*h)
	heap.Push(h, -1)
	fmt.Println(*h)
	fmt.Printf("%d", heap.Pop(h))
}
