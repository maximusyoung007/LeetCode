package solution

func SequenceReconstruction(nums []int, sequences [][]int) bool {
	n := len(nums)
	index := make([]int, n + 1)
	queue := make([]int, 0)
	m := make(map[int][]int, 0)

	for i := 0; i < len(sequences); i++ {
		for j, k := 0, 1; k < len(sequences[i]); j, k = j + 1, k + 1 {
			value, ok := m[sequences[i][j]]
			if !ok {
				value = make([]int, 0)
			}
			if !in(value, sequences[i][j]) {
				value = append(value, sequences[i][k])
				index[sequences[i][k]] += 1
			}

			m[sequences[i][j]] = value
		}
	}

	count := 0
	for i := 1; i < len(index); i++ {
		if index[i] == 0 {
			queue = append(queue, i)
			count++
			if count == 2 {
				return false
			}
		}
	}

	count = 0

	result := make([]int, 0)
	for len(queue) != 0 {
		u := queue[0]
		queue = queue[1:]
		result = append(result, u)
		t := m[u]
		if t != nil {
			for i := 0; i < len(t); i++ {
				index[t[i]]--
				if index[t[i]] == 0 {
					count++
					if count == 2 {
						return false
					}
					queue = append(queue, t[i])
				}
			}
			count = 0
		}
	}

	if len(result) != len(nums) {
		return false
	}
	for i := 0; i < len(result); i++ {
		if result[i] != nums[i] {
			return false
		}
	}
	return true
}

func in(nums []int, num int) bool{
	for i := 0; i < len(nums); i++ {
		if nums[i] == num {
			return true
		}
	}
	return false
}