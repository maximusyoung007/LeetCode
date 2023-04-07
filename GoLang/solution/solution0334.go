package solution

import "math"

/**
设置两个值，small 和 mid
遍历，如果小于small，就更新small
如果大于small,小于mid,就更新mid
如果大于mid，就返回true

可以更新small的原因，
3，5，1，2，3 将3更新为1，才可以判断1后面的2，3
3，5，1，7，3 7大于3，那么显然也大于1,1<3替换了也无所谓,实际上是扩大了选择的范围
*/
func IncreasingTriplet(nums []int) bool {
	small, mid := math.MaxInt, math.MaxInt
	for _, num := range nums {
		if num < small {
			small = num
		} else if num > small && num < mid {
			mid = num
		} else if num > mid {
			return true
		}
	}
	return false
}
