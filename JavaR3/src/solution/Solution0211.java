package solution;

public class Solution0211 {
	static class WordDictionary {

		boolean isEnd;
		WordDictionary[] next;

		public WordDictionary() {
			isEnd = false;
			next = new WordDictionary[26];
		}

		public void addWord(String word) {
			WordDictionary node = this;

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);

				if (node.next[c - 'a'] == null) {
					node.next[c - 'a'] = new WordDictionary();
				}
				node = node.next[c - 'a'];
			}

			node.isEnd = true;
		}

		public boolean search(String word) {
			WordDictionary node = this;

			return dfs(word, 0, node);
		}

		public boolean dfs(String word, int index, WordDictionary node) {
			if (index == word.length()) {
				return node.isEnd;
			}
			char c = word.charAt(index);
			if (c == '.') {
				for (int i = 0; i < 26; i++) {
					if (node.next[i] != null) {
						node = node.next[i];
						if (dfs(word, index+1, node)) {
							return true;
						}
					}
				}
				return false;
			} else {
				node = node.next[c - 'a'];
				if (node != null) {
					return dfs(word, index+1, node);
				} else {
					return false;
				}
			}
		}
	}

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad"));
		System.out.println(wordDictionary.search("bad"));
		System.out.println(wordDictionary.search(".ad"));
		System.out.println(wordDictionary.search("b.."));
	}
}
