package solution

func MaxChunksToSorted(arr []int) int {
	stack := make([]int, 0)
	for _, val := range arr {
		if len(stack) == 0 || val >= stack[len(stack)-1] {
			stack = append(stack, val)
		} else {
			max := stack[len(stack)-1]
			stack = stack[0 : len(stack)-1]
			for len(stack) > 0 && val < stack[len(stack)-1] {
				stack = stack[0 : len(stack)-1]
			}
			stack = append(stack, max)
		}
	}
	return len(stack)
}
