package main

import (
	"fmt"
	"golangR2/solution"
)

func main() {
	fmt.Println("leetcode goLang round2")

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
	nums := []int{2, 0, 2, 1, 1, 0}
	//nums := []int{2, 0, 1}
	solution.SortColors(nums)
	fmt.Println(nums)
}
