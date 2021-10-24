package solution

import (
	"math"
	"strings"
)

/*
给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。

注意:
十六进制中所有字母(a-f)都必须是小写。
十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；
对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
给定的数确保在32位有符号整数范围内。
不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。

示例 1：
输入:
26
输出:
"1a"

示例 2：
输入:
-1
输出:
"ffffffff"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
func ToHex(num int) string {
	if num == 0 {
		return "0"
	}
	s := "0123456789abcdefg"
	var num_ int64
	var sb strings.Builder
	if num < 0 {
		num_ = int64(num) + int64(math.Pow(2, 32))
	} else {
		num_ = int64(num)
	}
	var mod int64
	for {
		mod = num_ % 16
		num_ /= 16
		sb.WriteString(string(s[mod]))
		if num_ <= 0 {
			break
		}
	}
	return reverseString(sb.String())
}

func reverseString(str string) string {
	var bytes []byte = []byte(str)
	var build strings.Builder
	for i := 0; i < len(bytes); i++ {
		i2 := bytes[len(bytes)-i-1]
		build.WriteString(string(i2))
	}
	return build.String()
}
