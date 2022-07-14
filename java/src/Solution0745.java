import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。
 *
 * 实现 WordFilter 类：
 *
 * WordFilter(string[] words) 使用词典中的单词 words 初始化对象。
 * f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。
 * 如果存在不止一个满足要求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。
 *
 * 示例：
 * 输入
 * ["WordFilter", "f"]
 * [[["apple"]], ["a", "e"]]
 * 输出
 * [null, 0]
 * 解释
 * WordFilter wordFilter = new WordFilter(["apple"]);
 * wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。
 *
 * 提示：
 * 1 <= words.length <= 104
 * 1 <= words[i].length <= 7
 * 1 <= pref.length, suff.length <= 7
 * words[i]、pref 和 suff 仅由小写英文字母组成
 * 最多对函数 f 执行 104 次调用
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/prefix-and-suffix-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0745 {
	public static void main(String[] args) {
//		WordFilter wordFilter = new WordFilter(new String[]{"apple"});
//		System.out.println(wordFilter.f("b", "e"));

		WordFilter wordFilter = new WordFilter(new String[] {"abbba", "abba"});
		System.out.println(wordFilter.f("ab", "ba"));
	}
}

class WordFilter {
	TrieNode rootL;
	TrieNode rootR;

	class TrieNode {
		boolean end;
		TrieNode[] tns = new TrieNode[26];
		List<Integer> list = new ArrayList<>();
	}

	public void insert(String s, int pos, TrieNode root) {
		TrieNode p = root;

		for(int i = 0; i < s.length(); i++) {
			int u = s.charAt(i) - 'a';
			if (null == p.tns[u]) {
				p.tns[u] = new TrieNode();
			}
			p = p.tns[u];
			p.list.add(pos);
		}
		p.end = true;
	}

	public List<Integer> startsWith(String s, TrieNode root) {
		TrieNode p = root;
		for(int i = 0; i < s.length(); i++) {
			int u = s.charAt(i) - 'a';
			if (p.tns[u] == null) {
				return null;
			}
			p = p.tns[u];
		}
		return p.list;
	}

	public WordFilter(String[] word) {
		rootL = new TrieNode();
		rootR = new TrieNode();
		for (int i = 0; i < word.length; i++) {
			String s = word[i];
			insert(s, i, rootL);
			StringBuilder sb = new StringBuilder(s);
			sb = sb.reverse();
			insert(sb.toString(), i, rootR);
		}
	}

	public int f (String pref, String suff) {
		List<Integer> left = startsWith(pref, rootL);
		StringBuilder sb = new StringBuilder(suff);
		sb = sb.reverse();
		List<Integer> right = startsWith(sb.toString(), rootR);
		if (left == null || right == null) {
			return -1;
		}
		int p1 = left.size() - 1, p2 = right.size() - 1;
		while (p1 >= 0 && p2 >= 0) {
			int id1 = left.get(p1);
			int id2 = right.get(p2);
			if (id1 == id2) {
				return id1;
			}
			if (id1 > id2) {
				p1--;
			} else {
				p2--;
			}
		}
		return -1;
	}
}
