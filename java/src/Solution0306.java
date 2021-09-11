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
        return dfs(num, 0, 1, 1,1);
    }

    public boolean dfs(String num, int index1, int index2, int len1, int len2) {
        boolean r1 = false, r2 = false, r3 = false, r4 = false, r5 = false;
        int t1 = Integer.parseInt(num.substring(index1, index1 + len1));
        int t2 = Integer.parseInt(num.substring(index2, index2 + len2));
        int rt = t1 + t2;
        int rtc = rt;
        int len3 = 0;
        if (t1 != 0 && t2 != 0) {
            while (rtc > 0) {
                rtc /= 10;
                len3++;
            }
        } else {
            if (t1 == 0 && t2 != 0) {
                int t2c = t2;
                while (t2c > 0) {
                    t2c /= 10;
                    len3++;
                }
            } else if (t1 != 0 && t2 == 0) {
                int t1c = t1;
                while (t1c > 0) {
                    t1c /= 10;
                    len3++;
                }
            } else {
                len3 = 1;
            }
        }
        int index3 = index2 + len2;
        if (index3 + len3 > num.length()) {
            return false;
        }
        else {
            int t3 = Integer.parseInt(num.substring(index3, index3 + len3));
            if (t3 == t1 + t2) {
                if (index3 + len3 == num.length()) {
                    return true;
                } else {
                    r1 = dfs(num, index2, index2 + len2, len2, 1);
                }
            } else {
                r2 = dfs(num, index1 + 1, index2 + 1, len1, len2);
                r3 = dfs(num, index1, index2 + 1, len1, len2);
                r4 = dfs(num, index1, index2 + 1, len1 + 1, len2);
                r5 = dfs(num, index1, index2, len1, len2 + 1);
            }
        }
        return r1 || r2 || r3 || r4 || r5;
    }
}
