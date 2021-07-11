/**
 * 给你一个 rows x cols 的屏幕和一个用 非空 的单词列表组成的句子，请你计算出给定句子可以在屏幕上完整显示的次数。
 *
 * 注意：
 *
 * 一个单词不能拆分成两行。
 * 单词在句子中的顺序必须保持不变。
 * 在一行中 的两个连续单词必须用一个空格符分隔。
 * 句子中的单词总量不会超过 100。
 * 每个单词的长度大于 0 且不会超过 10。
 * 1 ≤ rows, cols ≤ 20,000.
 *  
 *
 * 示例 1：
 *
 * 输入：
 * rows = 2, cols = 8, 句子 sentence = ["hello", "world"]
 *
 * 输出：
 * 1
 *
 * 解释：
 * hello---
 * world---
 *
 * 字符 '-' 表示屏幕上的一个空白位置。
 *  
 *
 * 示例 2：
 *
 * 输入：
 * rows = 3, cols = 6, 句子 sentence = ["a", "bcd", "e"]
 *
 * 输出：
 * 2
 *
 * 解释：
 * a-bcd-
 * e-a---
 * bcd-e-
 *
 * 字符 '-' 表示屏幕上的一个空白位置。
 *  
 *
 * 示例 3：
 *
 * 输入：
 * rows = 4, cols = 5, 句子 sentence = ["I", "had", "apple", "pie"]
 *
 * 输出：
 * 1
 *
 * 解释：
 * I-had
 * apple
 * pie-I
 * had--
 *
 * 字符 '-' 表示屏幕上的一个空白位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sentence-screen-fitting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int nowRows = 0, nowCols = -1;
        int i = 0, size = 0;
        while (nowRows < rows) {
            String s = sentence[i];
            int restCols = cols - 1 - nowCols;
            if (s.length() > restCols) {
                nowCols = -1;
                nowRows += 1;
            }
            else {
                nowCols = nowCols + s.length();
                if (nowCols != cols - 1) {
                    nowCols += 1;
                }
                if (i == sentence.length - 1) {
                    size++;
                    i = 0;
                } else {
                    i++;
                }
            }
        }
        return size;
    }
}
