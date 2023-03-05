package solution

import "strconv"

/*
*
用map存
如果没有存过，则存一下，计次为1
如果存过了，就一次比较name(1),name(2),name(3)...是否存过，知道一个没有存过的name(n)
再存一下name(n),以及更新name
*/
func GetFolderNames(names []string) []string {
	m := make(map[string]int, 0)
	res := make([]string, len(names))
	for i, name := range names {
		num := m[name]
		if num == 0 {
			m[name] = 1
			res[i] = name
		} else {
			for m[name+"("+strconv.Itoa(num)+")"] > 0 {
				num++
			}
			m[name+"("+strconv.Itoa(num)+")"] = 1
			res[i] = name + "(" + strconv.Itoa(num) + ")"
			m[name] = num + 1
		}
	}
	return res
}
