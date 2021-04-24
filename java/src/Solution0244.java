import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请设计一个类，使该类的构造函数能够接收一个单词列表。然后再实现一个方法，该方法能够分别接收两个单词 word1 和 word2，并返回列表中这两个单词之间的最短距离。您的方法将被以不同的参数调用 多次。
 *
 * 示例:
 * 假设 words = ["practice", "makes", "perfect", "coding", "makes"]
 *
 * 输入: word1 = “coding”, word2 = “practice”
 * 输出: 3
 *
 * 输入: word1 = "makes", word2 = "coding"
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-word-distance-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0244 {
    public static void main(String[] args) {
        String[] s = new String[] {"practice", "makes", "perfect", "coding", "makes"};
        WordDistance wordDistance = new WordDistance(s);
        System.out.println(wordDistance.shortest("coding", "practice"));
        System.out.println(wordDistance.shortest("makes", "coding"));
    }

}
class WordDistance {
    Map<String, List<Integer>> m;
    public WordDistance(String[] wordsDict) {
        Map<String, List<Integer>> tm = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            List<Integer> tl = tm.getOrDefault(wordsDict[i], new ArrayList<>());
            tl.add(i);
            tm.put(wordsDict[i], tl);
        }
        this.m = tm;
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = m.get(word1);
        List<Integer> l2 = m.get(word2);
        int l = 0, r = 0, result = Integer.MAX_VALUE;
        while (l < l1.size() && r < l2.size()) {
            result = Math.min(result, Math.abs(l1.get(l) - l2.get(r)));
            if (l1.get(l) < l2.get(r)) {
                l++;
            } else {
                r++;
            }
        }
        return result;
    }
}
