package solution

import "strings"

/**
所有节点入栈
#可以看作是一个合法的节点
s,#,# 是合法的，可以合并成 #
*/
func IsValidSerialization(preorder string) bool {
	str := strings.Split(preorder, ",")
	stack := make([]string, 0)
	for i := 0; i < len(str); i++ {
		stack = append(stack, string(str[i]))
		for len(stack) >= 3 && stack[len(stack)-1] == "#" && stack[len(stack)-2] == "#" && stack[len(stack)-3] != "#" {
			stack = stack[0 : len(stack)-3]
			stack = append(stack, "#")
		}
	}
	return len(stack) == 1 && stack[0] == "#"
}
