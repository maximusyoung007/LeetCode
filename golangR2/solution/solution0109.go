package solution

func SortedListToBST(head *ListNode) *TreeNode {
	var sltb func(head *ListNode) *TreeNode

	//查找中点，中点左边就是左子树，右边就是右子树，依次类推
	sltb = func(head *ListNode) *TreeNode {
		if head == nil {
			return nil
		}
		if head.Next == nil {
			return &TreeNode{Val: head.Val}
		}
		//使用快慢指针查找中点
		slow := head
		fast := head
		pre := head
		for fast != nil && fast.Next != nil {
			pre = slow
			slow = slow.Next
			fast = fast.Next.Next
		}

		res := TreeNode{Val: slow.Val}
		//链表从此处断成两个
		pre.Next = nil

		res.Left = sltb(head)
		if slow != nil {
			res.Right = sltb(slow.Next)
		}
		return &res
	}

	return sltb(head)

}
