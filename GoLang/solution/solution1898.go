package solution

import (
	"fmt"
	"sort"
)

func maximumRemovals(s string, p string, removable []int) int {
	left, right := 0, len(removable)
	for left <= right {
		k := (left + right) / 2
		r := removable[0:k]
		if isSub(s, p, r) {
			left = k + 1
		} else {
			right = k - 1
		}
	}
	return left - 1
}

//如果ab不是ccb的子序列，则ab也不是cb的子序列,说明k太大了
func isSub(s string, p string, r1 []int) bool {
	r := make([]int, len(r1))
	copy(r, r1)
	sort.Ints(r)
	si, pi, ri := 0, 0, 0
	for si < len(s) {
		//当前位删除
		if ri < len(r) && si == r[ri] {
			si++
			ri++
			continue
		}
		if s[si] == p[pi] {
			pi++
			if pi == len(p) {
				return true
			}
		}
		si++
	}
	if pi == len(p) {
		return true
	}
	return false
}

func Test1898() {
	s := "abcacb"
	p := "ab"
	removable := []int{3, 1, 0}
	//s := "abcbddddd"
	//p := "abcd"
	//removable := []int{3, 2, 1, 4, 5, 6}
	//s := "abcab"
	//p := "abc"
	//removable := []int{0, 1, 2, 3, 4}
	/**
	"qlevcvgzfpryiqlwy"
	"qlecfqlw"
	[12,5]
	*/
	//s := "qlevcvgzfpryiqlwy"
	//p := "qlecfqlw"
	//removable := []int{12, 5}
	fmt.Println(maximumRemovals(s, p, removable))
}
