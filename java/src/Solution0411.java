/**
 * 通过将任意数量的 不相邻 子字符串替换为它们的长度，可以完成对字符串的 缩写 。 例如，像 "substitution" 这样的字符串可以缩写为（但不限于）：
 *
 * "s10n" ("s ubstitutio n")
 * "sub4u4" ("sub stit u tion")
 * "12" ("substitution")
 * "su3i1u2on" ("su bst i t u ti on")
 * "substitution" (不替换子字符串)
 * 注意："s55n" ("s ubsti tutio n") 不是 "substitution" 的有效缩写形式，因为它试图替换两个相邻的子字符串。
 *
 * 缩写的 长度 是未被替换的字母数加上被替换的字符串数。例如，缩写 "s10n" 的长度为 3（2 个字母 + 1 个子字符串），而 "su3i1u2on" 的长度为 9（6 个字母 + 3 子字符串）。
 *
 * 给你一个目标字符串 target 和一个字符串数组 dictionary 作为字典，为 target 找出并返回一个 最短 长度的缩写字符串，同时这个缩写字符串 不是 字典 dictionary 中其他字符串的缩写形式。如果有多个有效答案，可以返回其中任意一个。
 *
 * 示例 1：
 *
 * 输入：target = "apple", dictionary = ["blade"]
 * 输出："a4"
 * 解释："apple" 的最短缩写形式为 "5" ，但这也是 "blade" 的缩写形式之一。
 * 下一组最短缩写是 "a4" 和 "4e" ，其中 "4e" 也是 "blade" 的缩写形式之一，而 "a4" 不是。
 * 因此，返回 "a4" 。
 * 示例 2：
 *
 * 输入：target = "apple", dictionary = ["blade","plain","amber"]
 * 输出："1p3"
 * 解释："5" 同时是 "apple" 和字典中所有单词的缩写形式。
 * "a4" 同时是 "apple" 和 "amber" 的缩写形式。
 * "4e" 同时是 "apple" 和 "blade" 的缩写形式。
 * "1p3"、"2p2" 和 "3l1" 是 "apple" 的下一组最短缩写形式。
 * 因为它们不是字典中其他单词的缩写形式，返回其中任意一个都是正确的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-unique-word-abbreviation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0411 {
    String result;
    int minSize = Integer.MAX_VALUE;
    public String minAbbreviation(String target, String[] dictionary) {
        dfs(target, dictionary, "", 0, 0);
        return result;
    }

    public void dfs(String target, String[] dictionary, String current, int index, Integer num) {
        if (index == target.length()) {
            if (num > 0) {
                current = current + num.toString();
            }
            for (String ts : dictionary) {
                if (valid(ts, current)) {
                    return;
                }
            }
            if (current.length() < minSize) {
                minSize = current.length();
                result = current;
            }
            return;
        }
        dfs(target, dictionary, current, index + 1, num + 1);
        dfs(target, dictionary, current + (num > 0 ? num.toString() : "") + target.charAt(index), index + 1, 0);
    }

    public boolean valid(String word, String abbr) {
        int num = 0;
        int wordIndex = 0;
        for (int i = 0; i < abbr.length(); i++) {
            if (abbr.charAt(i) >= 'a' && abbr.charAt(i) <= 'z') {
                wordIndex = wordIndex + num + 1;
                if (wordIndex > word.length() || word.charAt(wordIndex - 1) != abbr.charAt(i)) {
                    return false;
                }
                num = 0;
            } else {
                if (num == 0 && abbr.charAt(i) == '0') {
                    return false;
                }
                num = num * 10 + (abbr.charAt(i) - '0');
            }
        }
        return wordIndex + num == word.length();
    }
}
