package solution

import (
	"fmt"
	datastructure "gproject/dataStructure"
)

func addTwoNumbers(l1 *datastructure.ListNode, l2 *datastructure.ListNode) *datastructure.ListNode {
	list1 := make([]int, 0)
	list2 := make([]int, 0)

	for l1 != nil {
		list1 = append(list1, l1.Val)
		l1 = l1.Next
	}

	for l2 != nil {
		list2 = append(list2, l2.Val)
		l2 = l2.Next
	}

	head := &datastructure.ListNode{0, nil}
	t, r := 0, 0
	for len(list1) > 0 && len(list2) > 0 {
		t = list1[len(list1)-1] + list2[len(list2)-1] + r
		if t >= 10 {
			r = t / 10
			t = t % 10
		} else {
			r = 0
		}
		node := &datastructure.ListNode{Val: t}
		node.Next = head.Next
		head.Next = node
		list1 = list1[:len(list1)-1]
		list2 = list2[:len(list2)-1]
	}

	for len(list1) > 0 {
		t = list1[len(list1)-1] + r
		if t >= 10 {
			r = t / 10
			t = t % 10
		} else {
			r = 0
		}
		node := &datastructure.ListNode{Val: t}
		node.Next = head.Next
		head.Next = node
		list1 = list1[:len(list1)-1]
	}

	for len(list2) > 0 {
		t = list2[len(list2)-1] + r
		if t >= 10 {
			r = t / 10
			t = t % 10
		} else {
			r = 0
		}
		node := &datastructure.ListNode{Val: t}
		node.Next = head.Next
		head.Next = node
		list2 = list2[:len(list2)-1]
	}

	if r > 0 {
		node := &datastructure.ListNode{Val: r}
		node.Next = head.Next
		head.Next = node
	}

	return head.Next
}

func Test0445() {
	//l11 := datastructure.ListNode{Val: 7}
	l12 := datastructure.ListNode{Val: 9}
	l13 := datastructure.ListNode{Val: 1}
	l14 := datastructure.ListNode{Val: 6}
	//l11.Next = &l12
	l12.Next = &l13
	l13.Next = &l14

	//n11 := datastructure.ListNode{Val: 5}
	//n12 := datastructure.ListNode{Val: 6}
	n13 := datastructure.ListNode{Val: 0}
	//n11.Next = &n12
	//n12.Next = &n13

	res := addTwoNumbers(&l12, &n13)
	fmt.Println(res)
}
