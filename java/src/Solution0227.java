import java.util.Stack;

/**
 * Given a string s which represents an expression, evaluate this expression and return its value. 
 *
 * The integer division should truncate toward zero.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 * Example 1:
 * Input: s = "3+2*2"
 * Output: 7
 *
 * Example 2:
 * Input: s = " 3/2 "
 * Output: 1
 *
 * Example 3:
 * Input: s = " 3+5 / 2 "
 * Output: 5
 *
 * Constraints:
 * 1 <= s.length <= 3 * 105
 * s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range [0, 231 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0227 {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        int n = s.length();
        int preSign = 1;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            else if (s.charAt(i) == '+') {
                preSign = 1;
                i++;
            }
            else if (s.charAt(i) == '-') {
                preSign = -1;
                i++;
            }
            else if (s.charAt(i) == '/' || s.charAt(i) == '*') {
                stack.push(String.valueOf(s.charAt(i)));
                i++;
            }
            else {
                int num = 0;
                while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                int nextIn = num;
                String st = "";
                if (!stack.isEmpty()) {
                    if (stack.peek().equals("*")) {
                        stack.pop();
                        int t = Integer.parseInt(stack.pop());
                        nextIn = t * nextIn;
                        st = String.valueOf(nextIn);
                        stack.push(st);
                        continue;
                    } else if (stack.peek().equals("/")) {
                        stack.pop();
                        int t = Integer.parseInt(stack.pop());
                        nextIn = t / nextIn;
                        st = String.valueOf(nextIn);
                        stack.push(st);
                        continue;
                    }
                }
                st = String.valueOf(preSign * nextIn);
                stack.push(st);
            }

        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += (Integer.parseInt(stack.pop()));
        }
        return result;
    }
}
