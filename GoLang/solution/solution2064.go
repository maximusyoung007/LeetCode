package solution

import "sort"

func minimizedMaximum(n int, quantities []int) int {
	sort.Ints(quantities)
	left, right := 0, quantities[len(quantities)-1]
	for left < right {

	}
}

func canDeliver(n int, quntities []int, x int) {
	i, k := 1, 0
	le := len(quntities)
	for i <= n && k < le {
		if quntities[k] >= x {
			i++
			quntities[k] -= x
		} else if quntities[k] < x && quntities[k] >= 0 {
			i++
			quntities[k] = 0
			k++
		}
	}
	if i 
}
