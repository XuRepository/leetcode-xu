package Tree

type Trie struct {
	child [26]*Trie //指针被声明之后，指向的是nil，通过判断child[i]==nil?判断是否已经分配
	isEnd bool
}

func Constructor() Trie {
	return Trie{} //括号内为空，都赋为默认值
}

func (this *Trie) Insert(word string) {

	node := this //记录当前遍历到的节点！
	for _, char := range word {
		if node.child[char-'a'] == nil {
			node.child[char-'a'] = &Trie{}
		}
		node = node.child[char-'a']
	}
	//标记为结束
	node.isEnd = true
}

func (this *Trie) Search(word string) bool {
	node := this
	for _, char := range word {
		if node.child[char-'a'] == nil {
			//子节点不存在
			return false
		} else {
			node = node.child[char-'a']
		}
	}
	return node.isEnd
}

func (this *Trie) StartsWith(prefix string) bool {

	node := this
	for _, char := range prefix {
		if node.child[char-'a'] == nil {
			//子节点不存在
			return false
		} else {
			node = node.child[char-'a']
		}
	}
	return true

}
