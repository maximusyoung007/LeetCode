package solution

import (
	"strconv"
	"strings"
)

/*
*
不断乘2，并取实数部分
直到小数部分为0或者超过32位
*/
func PrintBin(num float64) string {
	res := "0."
	var build strings.Builder
	build.WriteString(res)
	for build.Len() < 32 && num != 0 {
		num = num * 2
		t := int(num / 1)
		build.WriteString(strconv.Itoa(t))
		if num >= 1 {
			num -= 1
		}
	}
	if num != 0 {
		return "ERROR"
	}
	return build.String()
}
