/**
 * Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.
 *
 * Example 1:
 * Input: left = 5, right = 7
 * Output: 4
 *
 * Example 2:
 * Input: left = 0, right = 0
 * Output: 0
 *
 * Example 3:
 * Input: left = 1, right = 2147483647
 * Output: 0
 *
 * Constraints:
 *     0 <= left <= right <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0201 {
    public int rangeBitwiseEnd(int m, int n) {
        int shift = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }
}
