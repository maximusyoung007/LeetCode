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
	prices := []int{7, 1, 5, 3, 6, 4}
	print(solution.MaxProfit(prices))
}
