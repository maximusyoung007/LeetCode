package solution

import "gproject/dataStructure"

/*
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例 1：
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.

示例 2：
输入：l1 = [0], l2 = [0]
输出：[0]

示例 3：
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]

提示：
    每个链表中的节点数在范围 [1, 100] 内
    0 <= Node.val <= 9
    题目数据保证列表表示的数字不含前导零
*/
func AddTwoNumbers(l1 *datastructure.ListNode, l2 *datastructure.ListNode) *datastructure.ListNode {
	tail := &datastructure.ListNode{}
	head := tail
	var t int
	index := 0
	for l1 != nil && l2 != nil {
		t = l1.Val + l2.Val + index
		index = t / 10
		t = t % 10
		tail.Next = &datastructure.ListNode{Val: t}
		tail = tail.Next
		l1 = l1.Next
		l2 = l2.Next
	}

	if l1 != nil || l2 != nil {
		tNode := &datastructure.ListNode{Val: 0}
		if l1 != nil {
			tNode = l1
		} else if l2 != nil {
			tNode = l2
		}

		for tNode != nil {
			t = tNode.Val + index
			index = t / 10
			t = t % 10
			tail.Next = &datastructure.ListNode{Val: t}
			tail = tail.Next
			tNode = tNode.Next
		}
	}

	if index > 0 {
		tail.Next = &datastructure.ListNode{Val: index}
	}

	return head.Next
}
