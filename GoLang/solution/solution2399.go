package solution

func checkDistances(s string, distance []int) bool {
	n := len(s)
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			if s[i] == s[j] && j-i-1 != distance[s[i]-'a'] {
				return false
			}
		}
	}
	return true
}
