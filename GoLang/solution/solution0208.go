package solution

type Trie struct {
	child []*Trie
	isEnd bool
}

func Constructor0208() Trie {
	return Trie{make([]*Trie, 26), false}
}

func (this *Trie) Insert(word string) {
	node := this
	for _, value := range word {
		if node.child[value-'a'] == nil {
			node.child[value-'a'] = &Trie{make([]*Trie, 26), false}
		}
		node = node.child[value-'a']
	}
	node.isEnd = true
}

func (this *Trie) Search(word string) bool {
	node := this
	for _, value := range word {
		node = node.child[value-'a']
		if node == nil {
			return false
		}
	}
	return node.isEnd
}

func (this *Trie) StartsWith(prefix string) bool {
	node := this
	for _, value := range prefix {
		node = node.child[value-'a']
		if node == nil {
			return false
		}
	}
	return true
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
