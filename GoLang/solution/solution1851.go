package solution

import (
	"container/heap"
	"fmt"
	"sort"
)

/*
*
All queries are given at one time, so we can solve this problem offline.
1.  Sort input intervals by their start value;
2.  Sort input queries in increasing order;
3.  Create a min heap that keeps an interval's length and end value.
The order is determined by interval length so we can answer a query efficiently.
4.  for each query Q, add all intervals whose start values <= Q,
then remove all intervals whose end values < Q. The top of the min heap is the answer.

This solution is correct because for two different queries Q1 < Q2,
we process Q1 before Q2. All intervals with end values < Q1 must be also < Q2,
so before processing Q2, we have removed all intervals whose end values < Q1.
When processing Q2, we remove all intervals with end values in range [Q1, Q2 - 1].
*/
func minInterval(intervals [][]int, queries []int) []int {
	//方法1 计算intervals中每一个数出现的最小区间，存在map中，再依次比较queries,超时
	//m := make(map[int]int, 0)
	//for i := 0; i < len(intervals); i++ {
	//	for j := intervals[i][0]; j <= intervals[i][1]; j++ {
	//		_, ok := m[j]
	//		if !ok {
	//			m[j] = intervals[i][1] - intervals[i][0] + 1
	//		} else {
	//			if intervals[i][1]-intervals[i][0]+1 < m[j] {
	//				m[j] = intervals[i][1] - intervals[i][0] + 1
	//			}
	//		}
	//	}
	//}
	//
	//res := make([]int, 0)
	//for i := 0; i < len(queries); i++ {
	//	_, ok := m[queries[i]]
	//	if ok {
	//		res = append(res, m[queries[i]])
	//	} else {
	//		res = append(res, -1)
	//	}
	//}
	//return res

	res := make([]int, len(queries))
	//将intervals按start value排序
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	//一个小根堆，保存区间的长度和end value,按照长度排序
	h := IntervalHeap{}
	type pairInterval struct {
		q, index int
	}
	queriesPairs := make([]pairInterval, 0)
	for i := 0; i < len(queries); i++ {
		queriesPairs = append(queriesPairs, pairInterval{queries[i], i})
		//所有结果初始化为-1
		res[i] = -1
	}
	//将quries升序排序
	sort.Slice(queriesPairs, func(i, j int) bool {
		return queriesPairs[i].q < queriesPairs[j].q
	})
	j := 0
	for i := 0; i < len(queriesPairs); i++ {
		qt := queriesPairs[i]
		for ; j < len(intervals); j++ {
			//q大于interval的开始节点，说明q可能存在于这个区间内，入堆
			//因为q单调递增，所以对于后面的q来说，也可能在这个区间内
			if intervals[j][0] <= qt.q {
				heap.Push(&h, IntervalPair{intervals[j][1] - intervals[j][0] + 1, intervals[j][1]})
			} else {
				break
			}
		}
		for len(h) > 0 && h[0].right < qt.q {
			//如果q大于右区间，说明q不在这个区间内，继续查看下一个堆
			//如果这个q大于右区间，因为q是单调递增的，所以后面所有的q都大于右区间，所有可以出堆
			heap.Pop(&h)
		}
		//如果q在这个区间内，那么根据小根堆的特性，当前的值就是最小的，那么就把当前值放到结果集中
		if len(h) > 0 {
			res[qt.index] = h[0].l
		}
	}

	return res
}

type IntervalPair struct{ l, right int }
type IntervalHeap []IntervalPair

func (h IntervalHeap) Len() int            { return len(h) }
func (h IntervalHeap) Less(i, j int) bool  { return h[i].l < h[j].l }
func (h IntervalHeap) Swap(i, j int)       { h[i], h[j] = h[j], h[i] }
func (h *IntervalHeap) Push(x interface{}) { *h = append(*h, x.(IntervalPair)) }
func (h *IntervalHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func Test1851() {
	//intervals := [][]int{{1, 4}, {2, 4}, {3, 6}, {4, 4}}
	//queries := []int{2, 3, 4, 5}
	intervals := [][]int{{2, 3}, {2, 5}, {1, 8}, {20, 25}}
	queries := []int{2, 19, 5, 22}
	fmt.Println(minInterval(intervals, queries))
}
