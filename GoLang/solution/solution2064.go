package solution

import (
	"sort"
)

func MinimizedMaximum(n int, quantities []int) int {
	sort.Ints(quantities)
	left, right := 0, quantities[len(quantities)-1]+1
	for left < right {
		mid := (left + right + 1) / 2
		if canDeliver(n, quantities, mid) {
			right = mid - 1
		} else {
			left = mid
		}
	}
	return right + 1
}

func canDeliver(n int, quntities []int, x int) bool {
	//模拟每次分配x后，最后i和quntities的情况
	i, k := 0, 0
	le := len(quntities)
	q1 := make([]int, le)
	copy(q1, quntities)
	for i < n && k < le {
		if q1[k] >= x {
			i++
			q1[k] -= x
			if q1[k] == 0 {
				k++
			}
		} else if q1[k] < x && q1[k] >= 0 {
			i++
			k++
		}
	}
	//x太大，不够分, 当作正确情况处理，x向小端移动
	if i < n {
		return true
	}
	//x 太小，还有剩下的
	if k < le {
		return false
	}
	//x太小，还有剩的
	if k == le {
		k -= 1
		if q1[k] > x {
			return false
		}
	}
	return true

	//模拟每次分x个，可以分多少个商店
	//count := 0
	//for _, q := range quntities {
	//	count += (q-1)/x + 1
	//}
	//return count <= n
}
