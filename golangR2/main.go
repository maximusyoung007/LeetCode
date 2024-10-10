package main

import (
	"fmt"
	"golangR2/solution"
)

func main() {
	fmt.Println("leetcode goLang round2")

	graph := make([][]int, 4)
	//for i := 0; i < len(graph); i++ {
	//	graph[i] = make([]int, 0)
	//}
	//graph[0] = []int{1, 2, 3}
	//graph[1] = []int{0, 2}
	//graph[2] = []int{0, 1, 3}
	//graph[3] = []int{0, 2}
	//graph[0] = []int{1, 3}
	//graph[1] = []int{0, 2}
	//graph[2] = []int{1, 3}
	//graph[3] = []int{0, 2}
	//graph[0] = []int{4, 1}
	//graph[1] = []int{0, 2}
	//graph[2] = []int{1, 3}
	//graph[3] = []int{2, 4}
	//graph[4] = []int{3, 0}
	//graph[0] = []int{1, 4}
	//graph[1] = []int{0, 2}
	//graph[2] = []int{1}
	//graph[3] = []int{4}
	//graph[4] = []int{3, 0}
	graph[0] = []int{1, 2, 3}
	graph[1] = []int{0, 2}
	graph[2] = []int{0, 1, 3}
	graph[3] = []int{0, 2}
	//graph[4] = []int{3, 0}
	fmt.Println(solution.IsBipartite(graph))
	//n1 := solution.TreeNode{Val: 1}
	//n2 := solution.TreeNode{Val: 2}
	//n3 := solution.TreeNode{Val: 6}
	//n4 := solution.TreeNode{Val: 2}
	//n5 := solution.TreeNode{Val: 4}
	//n6 := solution.TreeNode{Val: 7}
	//n1.Right = &n2
	//n1.Right = &n3
	//n2.Left = &n4
	//n2.Right = &n5
	//n3.Right = &n6
	//res := solution.DeleteNode(&n1, 1)
	//n1 := solution.ListNode{Val: -10}
	//n2 := solution.ListNode{Val: -3}
	//n3 := solution.ListNode{Val: 0}
	//n4 := solution.ListNode{Val: 5}
	//n5 := solution.ListNode{Val: 9}
	//n1.Next = &n2
	//n2.Next = &n3
	//n3.Next = &n4
	//n4.Next = &n5
	//res := solution.SortedListToBST(&n1)
	//
	//fmt.Println(res)
	//n1 := solution.TreeNode{Val: 5}
	//n2 := solution.TreeNode{Val: 3}
	//n3 := solution.TreeNode{Val: 6}
	//n4 := solution.TreeNode{Val: 2}
	//n5 := solution.TreeNode{Val: 4}
	//n6 := solution.TreeNode{Val: 7}
	//n7 := solution.TreeNode{Val: 1}
	//n8 := solution.TreeNode{Val: 7}
	//n9 := solution.TreeNode{Val: 9}

	//n1.Left = &n2
	//n1.Right = &n3
	//n2.Left = &n4
	//n2.Right = &n5
	//n3.Left = &n6
	//n3.Right = &n6
	//n4.Left = &n7
	//n6.Left = &n8
	//n6.Right = &n9
	//res := solution.FindTarget(&n1, 9)
	//fmt.Println(res)
	//inorder := []int{9, 3, 15, 20, 7}
	//postorder := []int{9, 15, 7, 20, 3}
	//inorder := []int{3, 2, 1}
	//postorder := []int{3, 2, 1}
	//t := solution.BuildTree(inorder, postorder)
	//fmt.Println(t)
	//n4 := solution.TreeNode{Val: 4}
	//n5 := solution.TreeNode{Val: 5}
	//n6 := solution.TreeNode{Val: 6}
	//n7 := solution.TreeNode{Val: 7}
	//n1.Left = &n2
	//n1.Right = &n3
	//n2.Left = &n4
	//n2.Right = &n5
	//n3.Left = &n6
	//n3.Right = &n7
	//preorder := []int{1, 2, 4, 5, 3, 6, 7}
	//postorder := []int{4, 5, 2, 6, 7, 3, 1}
	//t := solution.ConstructFromPrePost(preorder, postorder)
	//
	//fmt.Println(t)
	//n1 := solution.TreeNode{Val: 236}
	//n2 := solution.TreeNode{Val: 104}
	//n3 := solution.TreeNode{Val: 701}
	//n4 := solution.TreeNode{Val: 227}
	//n5 := solution.TreeNode{Val: 911}
	//n1.Left = &n2
	//n1.Right = &n3
	//n2.Right = &n4
	//n3.Right = &n5
	//fmt.Println(solution.GetMinimumDifference(&n1))
	//strs := []string{"10", "0001", "111001", "1", "0"}
	//m := 5
	//n := 3
	//strs := []string{"10", "0", "1"}
	//m := 1
	//n := 1
	//fmt.Println(solution.FindMaxForm(strs, m, n))
	//nums := []int{1, 5, 11, 5}
	//nums := []int{1, 2, 3, 5}
	//fmt.Println(solution.CanPartition(nums))
	//text1 := "abcde"
	//text2 := "ace"
	//text1 := "abc"
	//text2 := "abc"
	//text1 := "abc"
	//text2 := "def"
	//fmt.Println(solution.LongestCommonSubsequence(text1, text2))
	//nums := []int{10, 9, 2, 5, 3, 7, 101, 18}
	//fmt.Println(solution.LengthOfLIS(nums))
	//s := "leetcod"
	//wordDict := []string{"leet", "code"}
	//s := "applepenapple"
	//wordDict := []string{"apple", "pen"}
	//s := "catsandog"
	//wordDict := []string{"cats", "dog", "sand", "and", "cat"}
	//fmt.Println(solution.WordBreak(s, wordDict))

	//fmt.Println(solution.NumSquares(12))
	//fmt.Println(solution.NumSquares(13))
	//fmt.Println(solution.NumDecodings("11"))
	//fmt.Println(solution.NumDecodings("12"))
	//fmt.Println(solution.NumDecodings("226"))
	//fmt.Println(solution.NumDecodings("06"))
	//fmt.Println(solution.NumDecodings("2261"))
	//fmt.Println(solution.NumDecodings("27"))
	//fmt.Println(solution.NumDecodings("1201234"))

	//matrix := [][]byte{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}
	//matrix := [][]byte{{'0', '1'}, {'1', '0'}}
	//fmt.Println(solution.MaximalSquare(matrix))

	//nums := []int{1, 2, 3, 4}
	//nums := []int{-1, -2, -3}
	//nums := []int{1, 2, 3, 4, 5}
	//nums := []int{1, 2}
	//fmt.Println(solution.NumberOfArithmeticSlices(nums))

	//nums := []int{1, 2, 3, 1}
	//nums := []int{2, 7, 9, 3, 1}
	//fmt.Println(solution.Rob(nums))

	//maxHeight := []int{5, 3, 4, 1, 1}
	//maxHeight := []int{6, 5, 3, 9, 2, 7}
	//maxHeight := []int{3, 2, 5, 5, 2, 3}
	//maxHeight := []int{5, 2, 4, 4}
	//println(solution.MaximumSumOfHeights(maxHeight))

	//ratings := []int{1, 0, 2}
	//ratings := []int{1, 2, 2}
	//print(solution.Candy(ratings))

	//intervals := [][]int{{1, 2}, {2, 4}, {1, 3}}
	//intervals := [][]int{{1, 2}, {2, 3}, {3, 4}, {1, 3}}
	//intervals := [][]int{{1, 2}, {1, 2}, {1, 2}}
	//intervals := [][]int{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}}
	//println(solution.EraseOverlapIntervals(intervals))
	//solution.PartitionLabels("aaa")
	//s := "ababcbacadefegdehijhklij"
	//s := "eccbbbbdec"
	//fmt.Println(solution.PartitionLabels(s))
	//prices := []int{7, 1, 5, 3, 6, 4}
	//print(solution.MaxProfit(prices))
	//println(solution.JudgeSquareSum(5))
	//println(solution.JudgeSquareSum(3))
	//println(solution.JudgeSquareSum(4))
	//println(solution.JudgeSquareSum(2))
	//fmt.Println(solution.ValidPalindrome("bbabcdabb"))
	//fmt.Println(solution.ValidPalindrome("bbabcabb"))
	//fmt.Println(solution.ValidPalindrome("aba"))
	//fmt.Println(solution.ValidPalindrome("abca"))
	//fmt.Println(solution.ValidPalindrome("abc"))
	//s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
	//s := "abpcplea"
	//dictionary := []string{"ale", "apple", "monkey", "plea"}
	//dictionary := []string{"d", "b", "c"}
	//fmt.Println(solution.FindLongestWord(s, dictionary))

	//println(solution.MySqrt(8))
	//println(solution.MySqrt(4))
	//println(solution.MySqrt(9))
	//println(solution.MySqrt(10))
	//println(solution.MySqrt(11))
	//println(solution.MySqrt(12))
	//println(solution.MySqrt(13))
	//println(solution.MySqrt(14))
	//println(solution.MySqrt(15))
	//println(solution.MySqrt(16))
	//println(solution.MySqrt(17))
	//println(solution.MySqrt(1))

	//nums = [5,7,7,8,8,10], target = 8

	//nums := []int{5, 5, 7, 7, 8, 8, 10}
	//fmt.Println(solution.SearchRange(nums, 6))
	//nums := []int{5, 8, 8, 8, 8, 10}
	//fmt.Println(solution.SearchRange(nums, 8))
	//nums := []int{}
	//fmt.Println(solution.SearchRange(nums, 0))
	//nums := []int{1}
	//fmt.Println(solution.SearchRange(nums, 1))
	//nums := []int{3, 2, 1, 5, 6, 4}
	//nums := []int{3, 2, 3, 1, 2, 4, 5, 5, 6}
	//print(solution.FindKthLargest(nums, 1))
	//print(solution.FindKthLargest(nums, 2))
	//print(solution.FindKthLargest(nums, 3))
	//print(solution.FindKthLargest(nums, 4))
	//print(solution.FindKthLargest(nums, 5))
	//print(solution.FindKthLargest(nums, 6))

	//nums1 := []int{1, 2, 3}
	//nums2 := []int{1, 3}
	//nums1 := []int{1, 2}
	//nums2 := []int{3, 4}
	//println(solution.FindMedianSortedArrays(nums1, nums2))
	//nums := []int{1, 1, 1, 2, 2, 3}
	//fmt.Println(solution.TopKFrequent(nums, 2))
	//nums := []int{1}
	//fmt.Println(solution.TopKFrequent(nums, 1))
	//nums := []int{-1, -1}
	//fmt.Println(solution.TopKFrequent(nums, 1))
	//nums := []int{1, 2}
	//fmt.Println(solution.TopKFrequent(nums, 2))
	//nums := []int{2, 0, 2, 1, 1, 0}
	//nums := []int{2, 0, 1}
	//solution.SortColors(nums)
	//fmt.Println(nums)
	//fmt.Println(solution.ClimbStairs(2))
	//fmt.Println(solution.ClimbStairs(3))
	//fmt.Println(solution.ClimbStairs(4))
}
