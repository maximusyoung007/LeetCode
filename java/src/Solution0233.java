/**
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * 示例 1：
 * 输入：n = 13
 * 输出：6
 *
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 *
 * 提示：
 * 0 <= n <= 2 * 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-digit-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0233 {
    public int countDigitOne(int n) {
        //low保留低位的数值
        long i = 1, low = 0;
        int result = 0;
        while (n > 0) {
            if (n % 10 == 0) {
                result += (n / 10) * i;
            }
            else if (n % 10 == 1) {
                result += (n / 10) * i + low + 1;
            }
            else if (n % 10 > 1) {
                result += (n / 10 + 1) * i;
            }
            low = i * (n % 10) + low;
            i = i * 10;
            n = n / 10;
        }
        return result;
    }
}
