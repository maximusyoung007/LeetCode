package solution

func MaximumSumOfHeights(maxHeights []int) int {
	length := len(maxHeights)
	stack := make([]int, 0)
	leftRes, rightRes := make([]int, length), make([]int, length)

	for i := 0; i < length; i++ {
		//如果是第一个元素，入栈
		if len(stack) == 0 {
			//stack[len(stack)] = maxHeights[i]
			stack = append(stack, maxHeights[i])
			leftRes[i] = maxHeights[i]
		} else if maxHeights[i] >= stack[len(stack)-1] {
			//如果大于栈顶元素，直接入栈
			stack = append(stack, maxHeights[i])
			leftRes[i] = leftRes[i-1] + maxHeights[i]
		} else if maxHeights[i] < stack[len(stack)-1] {
			count := 0
			leftRes[i] = leftRes[i-1] + maxHeights[i]
			for len(stack) > 0 && maxHeights[i] < stack[len(stack)-1] {
				count++
				leftRes[i] -= stack[len(stack)-1]
				stack = stack[0 : len(stack)-1]
			}
			for j := 0; j < count; j++ {
				stack = append(stack, maxHeights[i])
				leftRes[i] += maxHeights[i]
			}
		}
	}

	stack = make([]int, 0)

	for i := length - 1; i >= 0; i-- {
		k := length - i - 1
		if len(stack) == 0 {
			stack = append(stack, maxHeights[i])
			rightRes[k] = maxHeights[i]
		} else if maxHeights[i] >= stack[len(stack)-1] {
			//如果大于栈顶元素，直接入栈
			stack = append(stack, maxHeights[i])
			rightRes[k] = rightRes[k-1] + maxHeights[i]
		} else if len(stack) > 0 && maxHeights[i] < stack[len(stack)-1] {
			count := 0
			rightRes[k] = rightRes[k-1] + maxHeights[i]
			for maxHeights[i] < stack[len(stack)-1] {
				count++
				rightRes[k] -= stack[len(stack)-1]
				stack = stack[0 : len(stack)-1]
			}
			for j := 0; j < count; j++ {
				stack = append(stack, maxHeights[i])
				rightRes[k] += maxHeights[i]
			}
		}
	}

	max := 0
	for i := 0; i < length; i++ {
		if leftRes[i]+rightRes[i] > max {
			max = leftRes[i] + rightRes[i]
		}
	}

	return max
}
