package solution

import datastructure "gproject/dataStructure"

func MergeInBetween(list1 *datastructure.ListNode, a int, b int, list2 *datastructure.ListNode) *datastructure.ListNode {
	nodea := list1
	for i := 0; i < a-1; i++ {
		nodea = nodea.Next
	}
	nodeb := nodea.Next
	for i := a; i <= b; i++ {
		nodeb = nodeb.Next
	}
	tail := list2
	for tail.Next != nil {
		tail = tail.Next
	}
	nodea.Next = list2
	tail.Next = nodeb
	return list1
}
