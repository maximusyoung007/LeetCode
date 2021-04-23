/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例：
 *
 * 输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * 输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0186 {
    public void reverseWords(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char t = s[left];
            s[left] = s[right];
            s[right] = t;
            left++;
            right--;
        }
        int l = 0, r = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                r = i - 1;
                while(l < r) {
                    char t2 = s[l];
                    s[l] = s[r];
                    s[r] = t2;
                    l++;
                    r--;
                }
                l = i + 1;
            }
            if (i == s.length - 1) {
                r = i;
                while(l < r) {
                    char t2 = s[l];
                    s[l] = s[r];
                    s[r] = t2;
                    l++;
                    r--;
                }
            }
        }
    }
}
