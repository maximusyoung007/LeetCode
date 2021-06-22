import java.util.ArrayList;
import java.util.List;

/**
 * 请你写出一个能够举单词全部缩写的函数。
 *
 * 注意：输出的顺序并不重要。
 *
 * 示例：
 *
 * 输入: "word"
 * 输出:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generalized-abbreviation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0320 {
    List<String> wordList = new ArrayList<>();
    public List<String> generateAbbreviations(String word) {
        dfs(word, 0, 0, "");
        return wordList;
    }

    void dfs(String word, int index, Integer num, String current) {
        if (index == word.length()) {
            if (num > 0) {
                current = current + num.toString();
            }
            wordList.add(current);
            return;
        }
        dfs(word, index + 1, num + 1, current);
        dfs(word, index + 1,0,current + (num > 0 ? num.toString() : "") + word.charAt(index));
    }
}
