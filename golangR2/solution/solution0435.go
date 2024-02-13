package solution

import (
	"sort"
)

// 贪心策略为优先保留结尾小且不相交的区间
func EraseOverlapIntervals(intervals [][]int) int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][1] < intervals[j][1]
	})

	count := 0
	for i, j := 0, 1; i < len(intervals) && j < len(intervals); {
		if intervals[j][0] < intervals[i][1] {
			count++
		} else {
			i = j
		}
		j++
	}

	return count
}
