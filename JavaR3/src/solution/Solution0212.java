package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution0212 {
	class TrieNode {
		String word;
		TrieNode[] next = new TrieNode[26];
	}

	TrieNode root = new TrieNode();

	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (node.next[c - 'a'] == null) {
				node.next[c - 'a'] = new TrieNode();
			}

			node = node.next[c - 'a'];
		}

		node.word = word;
	}

	boolean[][] isVisited;
	Set<String> res = new HashSet<>();
	int[][] direction = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};

	public List<String> findWords(char[][] board, String[] words) {
		for (String word : words) {
			insert(word);
		}
		int m = board.length, n = board[0].length;
		isVisited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (root.next[board[i][j] - 'a'] != null) {
					isVisited[i][j] = true;
					dfs(board, isVisited, root.next[board[i][j] - 'a'], i, j);
					isVisited[i][j] = false;
				}
			}
		}

		List<String> result = new ArrayList<>(res);

		return result;
	}

	public void dfs(char[][] board, boolean[][] isVisited, TrieNode node, int i, int j) {
		if (node.word != null) {
			res.add(node.word);
		}

		for (int[] d : direction) {
			int nextI = i + d[0];
			int nextJ = j + d[1];

			if (nextI >= board.length || nextI < 0 || nextJ >= board[0].length || nextJ < 0) {
				continue;
			}

			if (isVisited[nextI][nextJ]) {
				continue;
			}

			int t = board[nextI][nextJ] - 'a';

			if (node.next[t] != null) {
				isVisited[nextI][nextJ] = true;
				dfs(board, isVisited, node.next[t], nextI, nextJ);
				isVisited[nextI][nextJ] = false;
			}

		}
	}
}
