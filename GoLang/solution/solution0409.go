package solution

/*
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindrome
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
func LongestPalindrome(s string) int {
	n := len(s)
	var result, odd int

	//使用map
	// counts := make(map[byte]int, n)
	// for i := 0; i < n; i++ {
	// 	ct := s[i]
	// 	counts[ct] += 1
	// }
	// //如果有多个奇数，v/2，相当于奇数都只取其中偶数个的或者不取，最后再加上最中间的那个奇数个
	// for _, v := range counts {
	// 	result += v / 2
	// 	if v % 2 != 0 {
	// 		odd = 1
	// 	}
	// }

	//使用数组
	var counts [128]int
	for i := 0; i < n; i++ {
		ct := int(s[i])
		counts[ct] += 1
	}
	//如果有多个奇数，v/2，相当于奇数都只取其中偶数个的或者不取，最后再加上最中间的那个奇数个
	for _, v := range counts {
		result += v /2
		if v % 2 != 0 {
			odd = 1
		}
	}
	result *= 2;
	result += odd
	return result
}