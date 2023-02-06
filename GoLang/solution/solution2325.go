package solution

func DecodeMessage(key string, message string) string {
	var byteKey []byte = []byte(key)
	t := byte('a')
	m1 := make(map[byte]byte)
	for _, val := range byteKey {
		_, ok := m1[val]
		//不是空格并且没有在key中出现过
		if val != ' ' && !ok {
			m1[val] = t
			t++
		}
	}
	m := []byte(message)
	for i, val := range m {
		if val != byte(' ') {
			m[i] = m1[val]
		}
	}
	return string(m)

}
