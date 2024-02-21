package solution

func ValidPalindrome(s string) bool {
	left, right := 0, len(s)-1

	var ts1, ts2 string
	for left < right {
		if s[left] == s[right] {
			left++
			right--
		} else {
			ts1 = s[left+1 : right+1]
			ts2 = s[left:right]
			break
		}
	}
	return isPalindrome(ts1) || isPalindrome(ts2)
}

func isPalindrome(s string) bool {
	left, right := 0, len(s)-1
	for left < right {
		if s[left] == s[right] {
			left++
			right--
		} else {
			break
		}
	}

	return left == right+1 || left == right
}
