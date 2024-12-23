package solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution0127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();

		queue.add(beginWord);
		visited.add(beginWord);
		int k = 1;
		int count = 1;

		while (!queue.isEmpty()) {
			int tk = 0;
			for (int i = 0; i < k; i++) {
				String t = queue.poll();
				for (String s : wordList) {
					if (canTransfer(t, s) && !visited.contains(s)) {
						if (s.equals(endWord)) {
							return count+1;
						}
						queue.add(s);
						visited.add(s);
						tk++;
					}
				}
			}
			if (tk != 0) {
				count++;
				k = tk;
			}
		}

		return 0;
	}

	public boolean canTransfer(String beginWord, String endWord) {
		int num = 0;
		for (int i = 0; i < beginWord.length(); i++) {
			if (beginWord.charAt(i) != endWord.charAt(i)) {
				num++;
			}
		}

		return num == 1;
	}
}
