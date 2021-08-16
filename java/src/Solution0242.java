/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 提示:
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0242 {
    public boolean isAnagram(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if (len1 != len2) {
            return false;
        }
        int[] sa = new int[26];
        int[] sb = new int[26];
        for (int i = 0; i < len1; i++) {
            int t1 = s.charAt(i) - 'a';
            int t2 = t.charAt(i) - 'a';
            sa[t1]++;
            sb[t2]++;
        }
        for (int i = 0; i < 26; i++) {
            if (sa[i] != sb[i]) {
                return false;
            }
        }
        return true;
    }
}
