import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个单词序列，判断其是否形成了一个有效的单词方块。
 *
 * 有效的单词方块是指此由单词序列组成的文字方块的 第 k 行 和 第 k 列 (0 ≤ k < max(行数, 列数)) 所显示的字符串完全相同。
 *
 * 注意：
 *
 * 给定的单词数大于等于 1 且不超过 500。
 * 单词长度大于等于 1 且不超过 500。
 * 每个单词只包含小写英文字母 a-z。
 *  
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   "abcd",
 *   "bnrt",
 *   "crmy",
 *   "dtye"
 * ]
 *
 * 输出：
 * true
 *
 * 解释：
 * 第 1 行和第 1 列都是 "abcd"。
 * 第 2 行和第 2 列都是 "bnrt"。
 * 第 3 行和第 3 列都是 "crmy"。
 * 第 4 行和第 4 列都是 "dtye"。
 *
 * 因此，这是一个有效的单词方块。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-word-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0422 {
    public boolean validWordSquare(List<String> words) {
        int size = words.size();
        int s = 0;
        Queue<String> queue = new LinkedList<>(words);
        String t = "";
        List<String> words2 = new ArrayList<>();
        int ts = size;
        while (!queue.isEmpty()) {
            String word = queue.poll();
            if (word.length() > 0) {
                t = t + word.charAt(0);
                if (word.length() > 1) {
                    word = word.substring(1);
                    queue.add(word);
                } else {
                    ts--;
                }
            }
            s++;
            if (s == size) {
                words2.add(t);
                t = "";
                s = 0;
                size = ts;
            }
        }
        if (words.size() != words2.size()) {
            return false;
        }
        for (int i = 0; i < words.size(); i++) {
            if (!words.get(i).equals(words2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
