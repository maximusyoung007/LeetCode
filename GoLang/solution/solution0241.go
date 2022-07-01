package solution

import "strconv"

func DiffWaysToCompute(expression string) []int {
	result := []int{}
	count := 0
	for i := 0; i < len(expression); i++ {
		if expression[i] == '+' || expression[i] == '-' || expression[i] == '*' {
			count++
		}
	}
	if count == 0 {
		num, _ := strconv.Atoi(expression)
		result = append(result, num)
		return result
	}

	for i := 0; i < len(expression); i++ {
		if expression[i] == '+' || expression[i] == '-' || expression[i] == '*' {
			left := DiffWaysToCompute(expression[:i])
			right := DiffWaysToCompute(expression[i+1:])
			for _, l := range left {
				for _, r := range right {
					switch expression[i] {
					case '+':
						result = append(result, l + r)
					case '-':
						result = append(result, l - r)
					case '*':
						result = append(result, l * r)
					}
				}
			}
		}
	}
	return result
}