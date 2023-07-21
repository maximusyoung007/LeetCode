package solution

import (
	"fmt"
	"math"
)

/**
求yi + yj + |xi - xj|最大值，因为j > i,且points按照横坐标x的值从小到大排序，所以xj>xi,所以原式可以转化为
求 yi+yj+xj-xi，即xj+yj+yi-xi的最大值，实际上是以(xj,yj)为右边界，求右边界内yi-xi的最大值
*/
func findMaxValueOfEquation(points [][]int, k int) int {
	queue := make([]equationPair, 0)
	res := math.MinInt
	for _, p := range points {
		//当前p[0]减去队首大于k,后面的肯定更大，出队
		for len(queue) > 0 && p[0]-queue[0].x > k {
			queue = queue[1:]
		}
		if len(queue) > 0 && queue[0].sub+p[0]+p[1] > res {
			res = queue[0].sub + p[0] + p[1]
		}
		for len(queue) > 0 {
			//如果当前值大于队尾元素，队尾元素出队，保持队列是单调递减的，队首就是最大的
			if queue[len(queue)-1].sub < p[1]-p[0] {
				queue = queue[:len(queue)-1]
			} else {
				break
			}
		}
		queue = append(queue, equationPair{p[0], p[1] - p[0]})
	}
	return res
}

type equationPair struct {
	x, sub int
}

func Test1499() {
	//nums := [][]int{{1, 3}, {2, 0}, {5, 10}, {6, -10}}
	//k := 1
	//nums := [][]int{{0, 0}, {3, 0}, {9, 2}}
	nums := [][]int{{-19, 9}, {-15, -19}, {-5, -8}}
	k := 10
	fmt.Println(findMaxValueOfEquation(nums, k))

}
