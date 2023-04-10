package solution

import datastructure "gproject/dataStructure"

/**
先求长度，再利用单调栈，如果当前元素比栈顶元素小，则压栈，否则依次出栈，直到当前元素比栈顶元素小，压栈
*/
func NextLargerNodes(head *datastructure.ListNode) []int {
	stack := make([][]int, 0)
	i := 0
	calLen := head
	length := 0
	for calLen != nil {
		length++
		calLen = calLen.Next
	}
	res := make([]int, length)
	for head != nil {
		if i == 0 {
			stack = append(stack, []int{head.Val, i})
		} else {
			if head.Val <= stack[len(stack)-1][0] {
				stack = append(stack, []int{head.Val, i})
			} else if head.Val > stack[len(stack)-1][0] {
				for len(stack) > 0 && head.Val > stack[len(stack)-1][0] {
					res[stack[len(stack)-1][1]] = head.Val
					stack = stack[0 : len(stack)-1]
				}
				stack = append(stack, []int{head.Val, i})
			}
		}
		head = head.Next
		i++
	}
	return res
}
