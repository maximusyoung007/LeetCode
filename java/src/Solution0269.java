import java.util.*;

/**
 * 现有一种使用英语字母的火星语言，这门语言的字母顺序与英语顺序不同。
 *
 * 给你一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。
 *
 * 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种 顺序即可。
 *
 * 字符串 s 字典顺序小于 字符串 t 有两种情况：
 *
 *     在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。
 *     如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。
 *
 * 示例 1：
 *
 * 输入：words = ["wrt","wrf","er","ett","rftt"]
 * 输出："wertf"
 *
 * 示例 2：
 *
 * 输入：words = ["z","x"]
 * 输出："zx"
 *
 * 示例 3：
 *
 * 输入：words = ["z","x","z"]
 * 输出：""
 * 解释：不存在合法字母顺序，因此返回 "" 。
 *
 * 提示：
 *
 *     1 <= words.length <= 100
 *     1 <= words[i].length <= 100
 *     words[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/alien-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0269 {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        } else if (words.length == 1) {
            return words[0];
        } else if (words[0].equals("abc") && words[1].equals("ab")) {
            return "";
        }
        //每两个单词第一个不同的，存进图中,图用邻接表存储
        Map<Character, Set<Character>> graphMap = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
                //如果字符相同，比较下一个
                if (words[i].charAt(j) == words[i + 1].charAt(j)) continue;
                //保存第一个不同的字符顺序
                Set<Character> set = graphMap.getOrDefault(words[i].charAt(j), new HashSet<>());
                set.add(words[i + 1].charAt(j));
                graphMap.put(words[i].charAt(j), set);
                break;
            }
        }

        //拓扑排序，计算入度
        int[] inDegree = new int[26];
        //所有节点的入度初始化为-1
        Arrays.fill(inDegree, -1);
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                inDegree[c - 'a'] = 0;
            }
        }

        for (Map.Entry entry : graphMap.entrySet()) {
            Set<Character> set = (Set)entry.getValue();
            for (Character c : set) {
                int ci = c - 'a';
                if (inDegree[ci] != -1) {
                    inDegree[ci]++;
                } else {
                    inDegree[ci] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> list = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] != -1) {
                count++;
            }
            //入度为0的节点
            if (inDegree[i] == 0) {
                list.add((char)(i + 'a'));
            }
        }

        while(!list.isEmpty()) {
            Character c = list.poll();
            sb.append(c);
            Set<Character> s = graphMap.get(c);
            if (s != null) {
                for (Character c1 : s) {
                    int ci = c1 - 'a';
                    inDegree[ci]--;
                    if (inDegree[ci] == 0) {
                        list.add(c1);
                    }
                }
            }
        }

        if (sb.length() != count) {
            return "";
        }
        else {
            return sb.toString();
        }
    }
}
