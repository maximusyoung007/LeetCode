package main

func TwoSum(numbers []int, target int) []int {
    i, j := 0, len(numbers) - 1

	for i < j {
		if numbers[i] + numbers[j] > target {
			j--
		} else if numbers[i] + numbers[j] < target {
			i++
		} else {
			return []int {i+1, j+1}
		}
	}

	return []int{}
}