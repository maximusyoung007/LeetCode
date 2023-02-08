package solution

import (
	"sort"
	"strings"
)

func RemoveSubFolders(folder []string) []string {
	sort.Strings(folder)
	res := make([]string, 0)
	res = append(res, folder[0])
	for i, j := 0, 1; j < len(folder); {
		n := len(folder[i])
		if strings.HasPrefix(folder[j], folder[i]) && folder[j][n] == '/' {
			j++
		} else {
			res = append(res, folder[j])
			i = j
			j++
		}
	}
	return res
}
