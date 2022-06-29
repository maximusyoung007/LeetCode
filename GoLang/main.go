package main

import (
	"fmt"
	"gproject/solution"
	// "gproject/dataStructure"
)

func main() {
	//404
	// node1 := datastructure.TreeNode{Val: 1, Left: nil, Right: nil}
	// node2 := datastructure.TreeNode{Val: 9, Left: nil, Right: nil}
	// node3 := datastructure.TreeNode{Val: 20, Left: nil, Right: nil}
	// node4 := datastructure.TreeNode{Val: 15, Left: nil, Right: nil}
	// node5 := datastructure.TreeNode{Val: 7, Left: nil, Right: nil}
	// node1 := datastructure.TreeNode{Val: 1, Left: nil, Right: nil}
	// node2 := datastructure.TreeNode{Val: 2, Left: nil, Right: nil}
	// node3 := datastructure.TreeNode{Val: 3, Left: nil, Right: nil}
	// node4 := datastructure.TreeNode{Val: 4, Left: nil, Right: nil}
	// node5 := datastructure.TreeNode{Val: 5, Left: nil, Right: nil}
	// node1.Left = &node2
	// node1.Right = &node3
	// node2.Left = &node4
	// node2.Right = &node5
	// fmt.Print(solution.SumOfLeftLeaves(&node1))
	//405
	// var s string = solution.ToHex(26)
	// fmt.Print(s + "\n");
	// s = solution.ToHex(-1)
	// fmt.Print(s)
	//409
	// var s string = "abccccdd"
	// fmt.Print(solution.LongestPalindrome(s))
	//412
	// s1 := solution.FizzBuzz(5)
	// for i := range s1 {
	// 	fmt.Print(s1[i] + " ")
	// }
	//414
	//112 2231 122535
	//nums1 := [...]int {1, 2, 2, 5, 3, 5}
	//fmt.Println("test")
	//fmt.Print(solution.ThirdMax(nums1[:]))
	//nums1 := []int{2, 7, 11, 15}
	//res := solution.TwoSum(nums1, 9)
	//for i := range res {
	//	fmt.Println(res[i])
	//}

	//n7 := &datastructure.ListNode{9, nil}
	//n6 := &datastructure.ListNode{9, n7}
	//n5 := &datastructure.ListNode{9, n6}
	//n4 := &datastructure.ListNode{9, n5}
	//n3 := &datastructure.ListNode{9, n4}
	//n2 := &datastructure.ListNode{9, n3}
	//n1 := &datastructure.ListNode{9, n2}
	//
	//l4 := &datastructure.ListNode{9, nil}
	//l3 := &datastructure.ListNode{9, l4}
	//l2 := &datastructure.ListNode{9, l3}
	//l1 := &datastructure.ListNode{9, l2}
	//
	//res := solution.AddTwoNumbers(n1, l1)
	//for res != nil {
	//	fmt.Println(res.Val)
	//	res = res.Next
	//}

	//0019
	//n5 := &datastructure.ListNode{5, nil}
	//n4 := &datastructure.ListNode{4, n5}
	//n3 := &datastructure.ListNode{3, n4}
	//n2 := &datastructure.ListNode{2, n3}
	//n1 := &datastructure.ListNode{1, n2}
	//res := solution.RemoveNthFromEnd(n1, 6)
	//for res != nil {
	//	fmt.Println(res.Val)
	//	res = res.Next
	//}

	//n1 := &datastructure.ListNode{1, nil}
	//res := solution.RemoveNthFromEnd(n1, 1)
	//for res != nil {
	//	fmt.Println(res.Val)
	//	res = res.Next
	//}

	//n2 := &datastructure.ListNode{2, nil}
	//n1 := &datastructure.ListNode{1, n2}
	//res := solution.RemoveNthFromEnd(n1, 1)
	//for res != nil {
	//	fmt.Println(res.Val)
	//	res = res.Next
	//}

	//0021
	//n3 := &datastructure.ListNode{Val: 0}
	//n2 := &datastructure.ListNode{Val: 2, Next: n3}
	//n1 := &datastructure.ListNode{Val: 1, Next: n2}
	//l3 := &datastructure.ListNode{Val: 4}
	//l2 := &datastructure.ListNode{Val: 3, Next: l3}
	//l1 := &datastructure.ListNode{Val: 1, Next: l2}
	//res := solution.MergeTwoLists(n3, nil)
	//for res != nil {
	//	fmt.Println(res.Val)
	//	res = res.Next
	//}
	//
	//fmt.Println()

	longUrl := "https://leetcode.com/problems/design-tinyurl"
	obj := solution.Constructor()
	url := obj.Encode(longUrl)
	ans := obj.Decode(url)
	fmt.Println(ans)
}
