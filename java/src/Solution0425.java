
import java.util.*;

/**
 * 给定一个单词集合 （没有重复），找出其中所有的 单词方块 。
 *
 * 一个单词序列形成了一个有效的单词方块的意思是指从第 k 行和第 k 列 (0 ≤ k < max(行数, 列数)) 来看都是相同的字符串。
 *
 * 例如，单词序列 ["ball","area","lead","lady"] 形成了一个单词方块，因为每个单词从水平方向看和从竖直方向看都是相同的。
 *
 * b a l l
 * a r e a
 * l e a d
 * l a d y
 * 注意：
 *
 * 单词个数大于等于 1 且不超过 500。
 * 所有的单词长度都相同。
 * 单词长度大于等于 1 且不超过 5。
 * 每个单词只包含小写英文字母 a-z。
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["area","lead","wall","lady","ball"]
 *
 * 输出：
 * [
 *   [ "wall",
 *     "area",
 *     "lead",
 *     "lady"
 *   ],
 *   [ "ball",
 *     "area",
 *     "lead",
 *     "lady"
 *   ]
 * ]
 *
 * 解释：
 * 输出包含两个单词方块，输出的顺序不重要，只需要保证每个单词方块内的单词顺序正确即可。
 *  
 *
 * 示例 2：
 *
 * 输入：
 * ["abat","baba","atan","atal"]
 *
 * 输出：
 * [
 *   [ "baba",
 *     "abat",
 *     "baba",
 *     "atan"
 *   ],
 *   [ "baba",
 *     "abat",
 *     "baba",
 *     "atal"
 *   ]
 * ]
 *
 * 解释：
 * 输出包含两个单词方块，输出的顺序不重要，只需要保证每个单词方块内的单词顺序正确即可。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0425 {
    class Trie2 {
        Trie2[] next;
        //前缀对应的单词
        List<String> wordList;

        public Trie2() {
            next = new Trie2[26];
            wordList = new ArrayList<>();
        }

        public void insert(String word) {
            Trie2 node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new Trie2();
                }
                node = node.next[c - 'a'];
                node.wordList.add(word);
            }
        }

        public boolean startsWith(String prefix) {
            Trie2 node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                node = node.next[c - 'a'];
                if (node == null) {
                    return false;
                }
            }
            return true;
        }

        public List<String> getWordsWithPrefix(String prefix) {
            Trie2 node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                node = node.next[c - 'a'];
                if (node == null) {
                    return new ArrayList<>();
                }
            }
            return node.wordList;
        }
    }
    Trie2 head = new Trie2();
    int n;
    String[] words;
    public List<List<String>> wordSquares(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            head.insert(word);
        }
        this.n = words[0].length();
        this.words = words;
        List<List<String>> result = new ArrayList<>();
        for (String word : words) {
            Stack<String> s = new Stack<>();
            s.push(word);
            dfs(1, s, result);
        }
        return result;
    }

    public void dfs(int step, Stack<String> partResult, List<List<String>> result) {
        if (step == n) {
            List<String> list = new ArrayList<>();
            list.addAll(partResult);
            result.add(list);
            return;
        }
        String prefix = "";
        for (String word : partResult) {
            prefix = prefix + word.charAt(step);
        }

        List<String> wordList = head.getWordsWithPrefix(prefix);
        for (String word : wordList) {
            partResult.push(word);
            dfs(step + 1, partResult, result);
            partResult.pop();
        }
    }

}
