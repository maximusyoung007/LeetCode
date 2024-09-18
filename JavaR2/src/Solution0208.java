public class Solution0208 {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		System.out.println(trie.search("app"));
	}
	static class Trie {
		Trie[] next;
		boolean flag;

		public Trie() {
			flag = false;
			next = new Trie[26];
		}

		public void insert(String word) {
			Trie node = this;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (node.next[c - 'a'] == null) {
					node.next[c - 'a'] = new Trie();
				}
				node = node.next[c - 'a'];
			}
			node.flag = true;

		}

		public boolean search(String word) {
			Trie node = this;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				node = node.next[c - 'a'];
				if (node == null) {
					return false;
				}
			}
			return node.flag;

		}

		public boolean startsWith(String prefix) {
			Trie node = this;
			for (int i = 0; i < prefix.length(); i++) {
				char c = prefix.charAt(i);
				node = node.next[c - 'a'];
				if (node == null) {
					return false;
				}
			}
			return true;
		}
	}
}
