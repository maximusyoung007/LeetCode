package solution

func SmallestEventMultiple(n int) int {
	oldN := n
	for n%oldN != 0 || n%2 != 0 {
		n++
	}
	return n
}
