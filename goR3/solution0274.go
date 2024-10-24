package main

import "sort"

func HIndex(citations []int) int {
	//0,1,3,5,6
	n := len(citations)

	sort.Ints(citations)

	//h=1,即最大的那个数大于等于1即可，这样就有1篇应用次数大于1
	//h=2,即倒数第2大的那个数大于等于2即可，这样就有2篇应用次数大于2
	//...
	//以此类推

	h := 1
	for i := n - 1; i >= 0; i-- {
		if citations[i] >= h {
			//边界处理
			if i != 0 {
				h++
			}
			continue
		} else {
			//本轮循环h没有通过，那么应用次数应该是上一轮循环的
			h--
			break
		}

	}

	return h
}
