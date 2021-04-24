import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
 *
 * word1 和 word2 是有可能相同的，并且它们将分别表示为列表中两个独立的单词。
 *
 * 示例:
 * 假设 words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * 输入: word1 = “makes”, word2 = “coding”
 * 输出: 1
 *
 * 输入: word1 = "makes", word2 = "makes"
 * 输出: 3
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-word-distance-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0245 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        Map<String, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            List<Integer> tl = m.getOrDefault(wordsDict[i], new ArrayList<>());
            tl.add(i);
            m.put(wordsDict[i], tl);
        }
        List<Integer> l1 = m.get(word1);
        List<Integer> l2 = m.get(word2);
        int l = 0, r = 0, result = Integer.MAX_VALUE;
        while (l < l1.size() && r < l2.size()) {
            if (Math.abs(l1.get(l) - l2.get(r)) > 0) {
                result = Math.min(result, Math.abs(l1.get(l) - l2.get(r)));
            }
            if (l1.get(l) < l2.get(r)) {
                l++;
            } else {
                r++;
            }
        }
        return result;
    }
}
