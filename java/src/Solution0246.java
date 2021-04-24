import java.util.HashMap;
import java.util.Map;

/**
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 *
 * 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
 *
 * 示例 1:
 * 输入: num = "69"
 * 输出: true
 *
 * 示例 2:
 * 输入: num = "88"
 * 输出: true
 *
 * 示例 3:
 * 输入: num = "962"
 * 输出: false
 *
 * 示例 4：
 * 输入：num = "1"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strobogrammatic-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0246 {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> m = new HashMap() {{
            put('6', '9');
            put('9', '6');
            put('8', '8');
            put('1', '1');
            put('0', '0');
        }};
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            if (!m.containsKey(num.charAt(left)) || !m.containsKey(num.charAt(right))) {
                return false;
            }
            if (m.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
