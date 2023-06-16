package solution

import (
	"container/heap"
	"fmt"
)

/*
小根堆，保存的是数组[index1, index2],index1为nums1的下标，index2为nums2的下标
初始时，将nums1全保存，即[0,0],[1,0],[2,0],....
nums1和nums2都有序，则最小的一定是[0,0],出堆，[0,1]进堆
比较[0,1]和[1,0],较小的出堆
如果[0,1]比较小，继续比较[0,2],[0,3]...
如果[1,0]比较小，继续比较[1,1],[1,2],[1,3]...
如果[2,0]比较小，继续比较[2,1],[2,2],[2,3]...
*/
func kSmallestPairs(nums1 []int, nums2 []int, k int) [][]int {
	hp := &smallHeap{}
	heap.Init(hp)
	var i int
	for i = 0; i < len(nums1); i++ {
		heap.Push(hp, sumStru{i, 0, nums1[i] + nums2[0]})
	}
	res := make([][]int, 0)
	i = 0
	for k > 0 && len(*hp) > 0 {
		t := heap.Pop(hp).(sumStru)
		res = append(res, []int{nums1[t.i], nums2[t.j]})
		k--
		if t.j < len(nums2)-1 {
			heap.Push(hp, sumStru{t.i, t.j + 1, nums1[t.i] + nums2[t.j+1]})
		}
	}
	return res
}

type sumStru struct {
	i, j, sum int
}
type smallHeap []sumStru

func (h smallHeap) Len() int {
	return len(h)
}

func (h smallHeap) Less(i, j int) bool {
	return h[i].sum < h[j].sum
}

func (h smallHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *smallHeap) Push(x any) {
	*h = append(*h, x.(sumStru))
}

func (h *smallHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func Test0373() {
	//nums1 := []int{1, 7, 11}
	//nums2 := []int{2, 4, 6}
	//k := 3
	//res := kSmallestPairs(nums1, nums2, k)
	//nums1 := []int{1, 1, 2}
	//nums2 := []int{1, 2, 3}
	//k := 2
	//res := kSmallestPairs(nums1, nums2, k)
	//fmt.Println(res)
	nums1 := []int{1, 2}
	nums2 := []int{3}
	k := 3
	res := kSmallestPairs(nums1, nums2, k)
	fmt.Println(res)

	//s1 := sumStru{11, 11, 11}
	//s2 := sumStru{10, 10, 10}
	//s3 := sumStru{12, 12, 12}
	//h := &smallHeap{}
	//heap.Init(h)
	//heap.Push(h, s1)
	//heap.Push(h, s2)
	//heap.Push(h, s3)
	//fmt.Println(heap.Pop(h).(sumStru).sum)
}
