import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given a string s. You can convert s to a palindrome by adding characters in front of it.
 *
 * Return the shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 * Input: s = "aacecaaa"
 * Output: "aaacecaaa"
 *
 * Example 2:
 * Input: s = "abcd"
 * Output: "dcbabcd"
 *
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of lowercase English letters only.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0214 {
    //1、减去前缀的最长回文子串 2、剩下的倒序加到原字符串之前
    public String shortestPalindrome(String s) {
        StringBuffer sb = new StringBuffer((CharSequence) s);
        String sr = sb.reverse().toString();
        String p = s + "#" + sr;
        int[] next = getNext(p);
        return sr.substring(0, sr.length() - next[p.length() - 1]) + s;
    }

    public int[] getNext(String s) {
        int[] result = new int[s.length()];
        result[0] = 0;
        for(int i = 1; i < result.length; i++) {
            int temp = result[i - 1];
            while(temp > 0 && s.charAt(i) != s.charAt(temp)) {
                temp = result[temp - 1];
            }
            if(s.charAt(i) == s.charAt(temp)) {
                temp++;
            }
            result[i] = temp;
        }
        return result;
    }
}
