package solution

import (
	"sort"
	"strings"
)

// 排序，如果是子文件夹，前一个肯定是后一个的前缀
// a,b,c,d 如果a是b的前缀，则a肯定也是c的前缀，后面遇到不是前缀的情况，就是另一个组了
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
