package solution

func MaximumSumOfHeights(maxHeights []int) int64 {
	length := len(maxHeights)
	stack := make([]int, 0)
	leftRes, rightRes := make([]int, length), make([]int, length)

	//左右两边都是递增的，先依次计算左边的，再计算右边的，再计算左右相加的，减去本身的
	//stack记录下标好像效率更高，但是我不想优化了

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
			stack = append(stack, maxHeights[i])
		}
	}

	stack = make([]int, 0)

	for i := length - 1; i >= 0; i-- {
		//k := length - i - 1
		if len(stack) == 0 {
			stack = append(stack, maxHeights[i])
			rightRes[i] = maxHeights[i]
		} else if maxHeights[i] >= stack[len(stack)-1] {
			//如果大于栈顶元素，直接入栈
			stack = append(stack, maxHeights[i])
			rightRes[i] = rightRes[i+1] + maxHeights[i]
		} else if maxHeights[i] < stack[len(stack)-1] {
			count := 0
			rightRes[i] = rightRes[i+1] + maxHeights[i]
			for len(stack) > 0 && maxHeights[i] < stack[len(stack)-1] {
				count++
				rightRes[i] -= stack[len(stack)-1]
				stack = stack[0 : len(stack)-1]
			}
			for j := 0; j < count; j++ {
				stack = append(stack, maxHeights[i])
				rightRes[i] += maxHeights[i]
			}
			stack = append(stack, maxHeights[i])
		}
	}

	var max int64
	max = 0
	for i := 0; i < length; i++ {
		if int64(leftRes[i])+int64(rightRes[i])-int64(maxHeights[i]) > max {
			max = int64(leftRes[i]) + int64(rightRes[i]) - int64(maxHeights[i])
		}
	}

	return max
}
