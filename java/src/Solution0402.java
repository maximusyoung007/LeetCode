/**
 *402 316 321 1081
 */

import java.util.Stack;

/**
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 *
 *  
 * 示例 1 ：
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。

 * 示例 2 ：
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。

 * 示例 3 ：
 * 输入：num = "10", k = 2
 * 输出："0"
 *
 * 解释：从原数字移除所有的数字，剩余为空就是 0
 * 提示：
 * 1 <= k <= num.length <= 105
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0402 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Stack<Character> stack = new Stack();
        int time = 0;
        int j = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (stack.size() == 0) {
                if (c != '0') {
                    stack.push(c);
                } else {
                    time++;
                }
                continue;
            }
            if (c > stack.peek()) {
                stack.push(c);
            } else {
                while (!stack.isEmpty() && c < stack.peek() && time != k) {
                    stack.pop();
                    time++;
                    if (time == k) {
                        j = i + 1;
                        break;
                    }
                }
                stack.push(c);
            }

        }
        if (j != 0) {
            for (int i = j; i < num.length(); i++) {
                char c = num.charAt(i);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder("");
        int n = num.length() - k;
        while (stack.size() > n) {
            stack.pop();
        }
        while (!stack.isEmpty()){
            Character c = stack.pop();
            sb.append(c);
        }
        int i = sb.length() - 1;
        int l = sb.length();
        int count = 0;
        while (i >= 0 && sb.charAt(i) == '0') {
            sb.deleteCharAt(i);
            i--;
            count++;
        }
        if (count == l) {
            return "0";
        }
        sb.reverse();
        return sb.toString();
    }
}
