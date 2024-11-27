package main

import (
	"fmt"
)

func main() {
	s := "ADOBECODEBANC"
	t := "ABC"
	//s := "a"
	//t := "aa"
	//s := "a"
	//t := "a"
	//s := "acbbaca"
	//t := "aba"
	//s := "aaaaaaaaaaaabbbbbcdd"
	//t := "abcdd"
	res := MinWindow(s, t)
	fmt.Println(res)
	//res := SummaryRanges([]int{0, 1, 2, 4, 5, 7})
	//res := SummaryRanges([]int{0, 2, 3, 4, 6, 8, 9})
	//res := SummaryRanges([]int{})
	//for i := range res {
	//	fmt.Println(res[i])
	//}
	//fmt.Println(LongestConsecutive([]int{100, 4, 200, 1, 3, 2}))
	//fmt.Println(LongestConsecutive([]int{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}))
	//[0,3,7,2,5,8,4,6,0,1]
	//nums := []int{1, 2, 3, 1}
	//k := 3
	//nums := []int{1, 0, 1, 1}
	//k := 1
	//nums := []int{1, 2, 3, 1, 2, 3}
	//k := 2
	//fmt.Println(ContainsNearbyDuplicate(nums, k))
	//fmt.Println(IsHappy(2))
	// nums := []int {2,7,11,15}
	// target := 9
	// nums := []int {3,2,4}
	//nums := []int {3,3}
	//target := 6
	//res := TwoSum0001(nums, target)
	//for i :=0; i < len(res); i++ {
	//	fmt.Println(res[i])
	//}
	//strs := []string{"eat", "tea", "tan", "ate", "nat", "bat"}
	// strs := []string{"a"}
	// res := GroupAnagrams(strs)
	// fmt.Println(res)

	// pattern := "abba"
	// s := "dog cat cat fish"
	// s := "anagram"
	// t := "nagaram"
	//s := "rat"
	//t := "car"

	//fmt.Println(IsAnagram(s, t))
	//pattern = "abba", s = "dog cat cat fish"
	// fmt.Println(WordPattern(pattern, s))
	// s := "egg"
	// t := "add"
	// s := "foo"
	// t := "bar"
	// s := "paper"
	// t := "title"
	// s := "badc"
	// t := "baba"
	// fmt.Print(IsIsomorphic(s, t))
	// ransomNote := "aa"
	// magazine := "aab"
	// fmt.Println(CanConstruct(ransomNote, magazine))
	// board := [][] int {{0,1,0},{0,0,1},{1,1,1},{0,0,0}}
	//0 1 0
	//0 0 1
	//1 1 1
	//0 0 0
	//[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
	// board := [][]int {{1,1},{1,0}}
	// GameOfLife(board)
	//matrix := [][]int{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}
	// matrix := [][]int{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}}
	// SetZeroes(matrix)
	//s := "wordgoodgoodgoodbestword"
	//words := []string{"word", "good", "best", "good"}
	//s := "lingmindraboofooowingdingbarrwingmonkeypoundcake"
	//words := []string{"fooo", "barr", "wing", "ding", "wing"}
	//s := "barfoothefoobarman"
	//words := []string{"foo", "bar"}
	//s := "wordgoodgoodgoodbestword"
	//words := []string{"word", "good", "best", "word"}
	//s := "barfoofoobarthefoobarman"
	//words := []string{"bar", "foo", "the"}
	//s := "aaa"
	//words := []string{"a", "a"}
	//s := "bcabbcaabbccacacbabccacaababcbb"
	//words := []string{"c", "b", "a", "c", "a", "a", "a", "b", "c"}
	//res := FindSubstring(s, words)
	//for _, r := range res {
	//	fmt.Println(r)
	//}

	//matrix := [][]int {{1,2,3,4},{5,6,7,8},{9,10,11,12}}
	// matrix := [][]int {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}
	//  Rotate1(matrix)
	//res := SpiralOrder(matrix)
	//输出：[1,2,3,6,9,8,7,4,5]
	// for i := 0; i < len(matrix); i++ {
	//fmt.Println(res[i])
	// }
	// s := "abcabcbb"
	//s := "bbbbb"
	//s := "pwwkew"
	// s := " "
	// fmt.Println(LengthOfLongestSubstring(s))
	//target := 11
	//nums := []int{1, 1, 1, 1, 1, 1, 1, 1}
	//nums := []int{1, 2, 3, 4, 5}
	//target := 7
	//nums := []int{2, 3, 1, 2, 4, 3}
	//fmt.Println(MinSubArrayLen(target, nums))
	//nums := []int{-1, 0, 1, 2, -1, -4}
	//nums := []int{0, 1, 1}
	//nums := []int{0, 0, 0, 0}
	//fmt.Println(ThreeSum(nums))
	//height := []int{1, 8, 6, 2, 5, 4, 8, 3, 7}
	//height := []int{1, 1}
	//fmt.Println(MaxArea(height))
	// numbers := []int {2,7,11,15}
	// target := 9
	// numbers := []int {2,3,4}
	// target := 6
	//numbers := []int {-1,0}
	//target := -1
	//res := TwoSum(numbers, target)
	//for _, r := range res {
	//	fmt.Println(r)
	//}
	//s := "abc"
	//t := "ahbgdc"
	// s := "axc"
	// t := "ahbgdc"
	// fmt.Println(IsSubsequence(s, t))
	//s := "A man, a plan, a canal: Panama"
	// s := "race a car"
	// s := "0P"
	//fmt.Println(IsPalindrome(s))
	//words := []string{"This", "is", "an", "example", "of", "text", "justification."}
	//words := []string{"This", "is", "an", "example", "of", "text"}
	//maxWidth := 16
	//words := []string{"What", "must", "be", "acknowledgment", "shall", "be"}
	//maxWidth := 16

	// words := []string{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a",
	// "computer.", "Art", "is", "everything", "else", "we", "do"}
	// maxWidth := 20
	// res := FullJustify(words, maxWidth)
	// for _, s := range res {
	// fmt.Println(s)
	// }
	// strs := []string {"flower","flow","flight"}
	// strs := []string {"dog","racecar","car"}
	// res := LongestCommonPrefix(strs)
	// fmt.Println(res)
	// s := "   fly me   to   the moon  "
	//fmt.Println(LengthOfLastWord(s))
	//num := 3749
	//num := 58
	//num := 1994
	//res := IntToRoman(num)
	//fmt.Println(res)
	//height := []int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
	// height := []int{4, 2, 0, 3, 2, 5}
	//res := TrapTwoPoints(height)
	// res := TrapMonotonicStack(height)
	// s := "III"
	// s := "IV"
	// s := "IX"
	// s := "LVIII"
	//s := "MCMXCIV"
	//res := RomanToInt(s)
	//fmt.Println(res)
	// rating := []int{1, 0, 2} //5
	// rating := []int{1, 2, 2} //4
	// rating := []int {1,3,2,2,1} //7
	// rating := []int {1,2,87,87,87,2,1} //13
	// rating := []int {29,51,87,87,72,12} //12
	// rating := []int {1,3,4,5,2} //11
	// rating := []int {1,2,3,1,0} //9
	// rating := []int {1,2,3,5,4,3,2,1,4,3,2,1,3,2,1,1,2,3,4}
	// res := Candy(rating)
	// fmt.Println(res)
	// gas := []int {1,2,3,4,5}
	// cost := []int {3,4,5,1,2}
	//gas := []int {2,3,4}
	//cost := []int {3,4,3}
	//fmt.Println(CanCompleteCircuit(gas, cost))
	// nums := []int {1,2,3,4}
	// nums := []int {-1,1,0,-3,3}
	// res := ProductExceptSelf(nums)
	// for _, v :=range res {
	// fmt.Println(v)
	// }
	// obj := Constructor();
	// param_1 := obj.Insert(val);
	// param_2 := obj.Remove(val);
	// param_3 := obj.GetRandom();
	//citations := []int{3, 0, 6, 1, 5}
	// citations := []int{1, 3, 1}
	//citations := []int{0}
	//citations := []int{1}
	// fmt.Println(HIndex(citations))
	// nums := []int {2,3,1,1,4}
	//nums := []int {2,3,0,1,4}
	//fmt.Println(Jump(nums))
	//nums := []int{2, 3, 1, 1, 4}
	//nums := []int{3, 2, 1, 0, 4}
	//nums := []int{0}
	// nums := []int{0, 2, 3}
	// fmt.Println(CanJump(nums))
	//prices := []int{7, 1, 5, 3, 6, 4}
	//prices := []int{1, 2, 3, 4, 5}
	//res := MaxProfit2(prices)
	//fmt.Println(res)

	// nums := []int {7,1,5,3,6,4}
	//nums := []int {7,6,4,3,1}
	//res := MaxProfit(nums)
	//fmt.Println(res)

	// nums := []int{1, 2, 3, 4, 5, 6, 7}
	// Rotate(nums, 3)
	// fmt.Println(nums)
	//nums := []int{1, 1, 1, 2, 2, 2, 3}
	//res := RemoveDuplicates2(nums)
	//fmt.Println(res)
	// nums := []int {0,0,1,1,1,2,2,3,3,4}
	// res := RemoveDuplicates(nums)
	// fmt.Println(res)
	// nums := []int {3,2,2,3}
	// val := 3
	// nums := []int {0,1,2,2,3,0,4,2}
	// val := 2
	// res := RemoveElement(nums, val)
	// fmt.Println(res)

	// nums1 := []int{1, 2, 3, 0, 0, 0}
	// nums2 := []int{2, 5, 6}
	// m := 3
	// n := 3
	// nums1 := []int {1}
	// m := 1
	// nums2 := []int {}
	// n := 0
	// nums1 := []int {0}
	// m := 0
	// nums2 := []int {1}
	// n := 1
	// Merge(nums1, m, nums2, n)

	// for _, num := range nums1 {
	// fmt.Println(num)
	// }
	//nums := []int{2, 2, 1, 1, 1, 2, 2}
	//fmt.Println(MajorityElement(nums))
	fmt.Println("golang round 3")
}
