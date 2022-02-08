package solution

import datastructure "gproject/dataStructure"

/*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

示例 1：
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]

示例 2：
输入：head = [1], n = 1
输出：[]

示例 3：
输入：head = [1,2], n = 1
输出：[1]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
/*
设置两个指针 fast 、slow，fast先走k步，如果走不到第k步（None节点是可以走到的，但是None节点没有next，所以只能走到None），说明链表长度不够k，直接返回head；
如果走到第k步，发现该节点是None节点，说明链表的长度等于k，头节点就是倒数第k个节点，返回 head.next；
否则，令 fast 和 slow 开始同步往下移动，直到 fast 移动到最后一个节点（不包含None），
此时slow就是倒数第 k 个节点的前一个节点，之后删除倒数第k个节点就很容易了。
原文链接：https://blog.csdn.net/qq_34342154/article/details/78215177
*/
func RemoveNthFromEnd(head *datastructure.ListNode, n int) *datastructure.ListNode {
	fast := head
	slow := head
	i := 0
	for fast != nil && i < n {
		fast = fast.Next
		i++
	}
	//长度不够n,直接返回head
	if i < n {
		return head
	} else if fast == nil { //长度刚好是n
		return head.Next
	}

	for fast.Next != nil {
		fast = fast.Next
		slow = slow.Next
		i++
	}

	slow.Next = slow.Next.Next
	return head
}
