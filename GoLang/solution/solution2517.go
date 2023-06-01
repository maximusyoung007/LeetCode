package solution

import "sort"

/**
先排序
令left=0, right=price[n-1]-price[0]
则满足条件的最大差值一定在left和right之间，通过二分查找 查最大差值
判断甜蜜度是否可行，定义pre表示上一个选取好的，遍历price,cur表示当前遍历到的
如果cur-pre >= x,数量+1，如果数量大于k，则返回true
*/
func MaximumTastiness(price []int, k int) int {
	sort.Ints(price)
	n := len(price)
	left, right := 0, price[n-1]-price[0]
	for left < right {
		mid := (left + right + 1) / 2
		if ok(price, mid, k) {
			left = mid
		} else {
			right = mid - 1
		}
	}
	return left
}

func ok(price []int, mid int, k int) bool {
	pre := -mid
	count := 0
	for _, p := range price {
		if p-pre >= mid {
			pre = p
			count++
		}
	}
	return count >= k
}
