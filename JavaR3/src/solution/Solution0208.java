package solution;

public class Solution0208 {
	class Trie {

		boolean isEnd;
		Trie[] next;

		public Trie() {
			isEnd = false;
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

			node.isEnd = true;
		}

		public boolean search(String word) {
			Trie node = this;

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (node.next[c - 'a'] == null) {
					return false;
				}
				node = node.next[c - 'a'];
			}

			return node.isEnd;
		}

		public boolean startsWith(String prefix) {
			Trie node = this;

			for (int i = 0; i < prefix.length(); i++) {
				char c = prefix.charAt(i);
				if (node.next[c-'a'] == null) {
					return false;
				}
				node = node.next[c - 'a'];
			}

			return true;
		}
	}

}
