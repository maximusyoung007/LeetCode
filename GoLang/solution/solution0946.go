package solution

func ValidateStackSequences(pushed []int, popped []int) bool {
	stack := make([]int, 0)
	stack = append(stack, pushed[0])
	i, j := 1, 0
	for len(stack) > 0 {
		for len(stack) > 0 && stack[len(stack)-1] == popped[j] {
			j++
			stack = stack[0 : len(stack)-1]
		}
		if i < len(pushed) {
			stack = append(stack, pushed[i])
			i++
		}
		if len(stack) > 0 {
			if i == len(pushed) && stack[len(stack)-1] != popped[j] {
				break
			}
		}
	}
	if j == len(popped) {
		return true
	}
	return false
}
