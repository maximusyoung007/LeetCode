package main

func LongestCommonPrefix(strs []string) string {
	ts := strs[0]
	for i := 1; i < len(strs); i++ {
		s := strs[i]

		var j int
		for j = 0; j < len(ts) && j < len(s); j++ {
			if ts[j] != s[j] {
				break
			}
		}
		ts = ts[0:j]
	}

	return ts
}