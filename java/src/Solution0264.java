import java.util.*;

/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return the nth ugly number.
 *
 * Example 1:
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

 * Example 2:
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 *  
 * Constraints:
 * 1 <= n <= 1690
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        int i = 2;
        while (dp[n] == 0) {
            int num1 = dp[p2] * 2, num2 = dp[p3] * 3, num3 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num1, num2), num3);
            if (dp[i] == num1) {
                p2++;
            }
            if (dp[i] == num2) {
                p3++;
            }
            if (dp[i] == num3) {
                p5++;
            }
            i++;
        }
        return dp[n];
    }
}
