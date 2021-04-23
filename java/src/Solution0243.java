/**
 * 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
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
 * 链接：https://leetcode-cn.com/problems/shortest-word-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int l = -1, r = -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if(wordsDict[i].equals(word1)) {
                l = i;
            }
            if (wordsDict[i].equals(word2)) {
                r = i;
            }
            if (l >= 0 && r >= 0) {
                result = Integer.min(result, Math.abs(l - r));
            }
        }
        return result;
    }
}
