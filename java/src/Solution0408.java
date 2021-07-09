import java.util.ArrayList;
import java.util.List;

/**
 * 给一个 非空 字符串 s 和一个单词缩写 abbr ，判断这个缩写是否可以是给定单词的缩写。
 *
 * 字符串 "word" 的所有有效缩写为：
 *
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 注意单词 "word" 的所有有效缩写仅包含以上这些。任何其他的字符串都不是 "word" 的有效缩写。
 *
 * 注意:
 * 假设字符串 s 仅包含小写字母且 abbr 只包含小写字母和数字。
 *
 * 示例 1:
 *
 * 给定 s = "internationalization", abbr = "i12iz4n":
 *
 * 函数返回 true.
 *  
 *
 * 示例 2:
 *
 * 给定 s = "apple", abbr = "a2e":
 *
 * 函数返回 false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-word-abbreviation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0408 {
    public boolean validWordAbbreviation(String word, String abbr) {
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
