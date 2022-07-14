package solution

import "strings"

type TrieNode struct {
	child []*TrieNode
	list  []int
}

type WordFilter struct {
	rootL *TrieNode
	rootR *TrieNode
}

func Constructor745(words []string) WordFilter {
	rootL := &TrieNode{make([]*TrieNode, 26), make([]int, 0)}
	rootR := &TrieNode{make([]*TrieNode, 26), make([]int, 0)}
	p := rootL
	q := rootR
	for index, s := range words {
		for _, value := range s {
			if p.child[value-'a'] == nil {
				p.child[value-'a'] = &TrieNode{child: make([]*TrieNode, 26), list: make([]int, 0)}
			}
			p = p.child[value-'a']
			p.list = append(p.list, index)
		}
		p = rootL

		for i := len(s) - 1; i >= 0; i-- {
			value := s[i]
			if q.child[value-'a'] == nil {
				q.child[value-'a'] = &TrieNode{child: make([]*TrieNode, 26), list: make([]int, 0)}
			}
			q = q.child[value-'a']
			q.list = append(q.list, index)
		}
		q = rootR
	}
	return WordFilter{rootL: rootL, rootR: rootR}
}

func startWith(s string, trieNode *TrieNode) []int {
	for i := 0; i < len(s); i++ {
		u := s[i] - 'a'
		if trieNode.child[u] == nil {
			return nil
		}
		trieNode = trieNode.child[u]
	}
	return trieNode.list
}

func (this *WordFilter) F(pref string, suff string) int {
	rootL, rootR := this.rootL, this.rootR
	left := startWith(pref, rootL)
	suff = myReverse(suff)
	right := startWith(suff, rootR)
	if left == nil || right == nil {
		return -1
	}
	p1, p2 := len(left)-1, len(right)-1
	for p1 >= 0 && p2 >= 0 {
		l := left[p1]
		r := right[p2]
		if l == r {
			return l
		} else if l > r {
			p1--
		} else {
			p2--
		}
	}
	return -1
}

//leetcode不支持reverse()
func myReverse(str string) string {
	var bytes []byte = []byte(str)
	var build strings.Builder
	for i := 0; i < len(bytes); i++ {
		i2 := bytes[len(bytes)-i-1]
		build.WriteString(string(i2))
	}
	return build.String()
}
