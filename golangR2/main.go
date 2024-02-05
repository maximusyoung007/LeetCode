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
	maxHeight := []int{5, 2, 4, 4}
	println(solution.MaximumSumOfHeights(maxHeight))
}
