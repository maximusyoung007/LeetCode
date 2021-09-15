/**
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 *
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 * 示例 1:
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 *
 * 示例 2:
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 * 进阶:
 * 你如何处理一个溢出的过大的整数输入?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0306 {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        return dfs(num,0, 0);
    }

    public boolean dfs(String num, int startIndex, int endIndex) {
        boolean res = false;
        if (endIndex >= num.length()) {
            return false;
        }
        for (int len1 = 1; len1 + startIndex <= num.length(); len1++) {
            for (int len2 = 1; startIndex + len1 + len2 <= num.length(); len2++) {
                String num1 = num.substring(startIndex, startIndex + len1);
                String num2 = num.substring(startIndex + len1, startIndex + len1 + len2);
                if (num1.length() > 1 && num1.charAt(0) == '0') {
                    continue;
                }
                if (num2.length() > 1 && num2.charAt(0) == '0') {
                    continue;
                }
                String sum = add(num1, num2);
                int len3 = sum.length();
                if (startIndex + len1 + len2 + len3 <= num.length()) {
                    String num3 = num.substring(startIndex + len1 + len2, startIndex + len1 + len2 + len3);
                    if (sum.equals(num3)) {
                        if (startIndex + len1 + len2 + len3 == num.length()) {
                            return true;
                        }
                        res = dfs(num, startIndex + len1, startIndex + len1 + len2 + len3);
                    }
                }
            }
        }
        return res;
    }

    public String add(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int len1 = s1.length() - 1;
        int len2 = s2.length() - 1;
        while (len1 >= 0 && len2 >= 0) {
            int t = (s1.charAt(len1) - '0') + (s2.charAt(len2) - '0') + carry;
            carry = t / 10;
            t %= 10;
            len1--;
            len2--;
            sb.append(t);
        }
        if (len1 >= 0) {
            while (len1 >= 0) {
                int t = (s1.charAt(len1) - '0') + carry;
                carry = t / 10;
                t %= 10;
                len1--;
                sb.append(t);
            }
        }
        if (len2 >= 0) {
            while (len2 >= 0) {
                int t = (s2.charAt(len2) - '0') + carry;
                carry = t / 10;
                t %= 10;
                len2--;
                sb.append(t);
            }
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
