package solution

import datastructure "gproject/dataStructure"

/*
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例 1：
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]

示例 2：
输入：l1 = [], l2 = []
输出：[]

示例 3：
输入：l1 = [], l2 = [0]
输出：[0]

提示：
    两个链表的节点数目范围是 [0, 50]
    -100 <= Node.val <= 100
    l1 和 l2 均按 非递减顺序 排列

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
func MergeTwoLists(list1 *datastructure.ListNode, list2 *datastructure.ListNode) *datastructure.ListNode {
	tail := &datastructure.ListNode{}
	head := tail

	for list1 != nil && list2 != nil {
		temp := &datastructure.ListNode{}
		if list1.Val <= list2.Val {
			temp = &datastructure.ListNode{Val: list1.Val}
			list1 = list1.Next
		} else if list2.Val < list1.Val {
			temp = &datastructure.ListNode{Val: list2.Val}
			list2 = list2.Next
		}
		tail.Next = temp
		tail = tail.Next
	}

	if list1 != nil {
		tail.Next = list1
	}
	if list2 != nil {
		tail.Next = list2
	}

	return head.Next
}
