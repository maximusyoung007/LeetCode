import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 *
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 *
 * 示例 1：
 *
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * 示例 2：
 *
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 *  
 * 提示：
 *
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-subarray-minimums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0907 {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n];
        Arrays.fill(pre, -1);
        int[] next = new int[n];
        Arrays.fill(next, n);
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && arr[i] < arr[stack.peek()]) {
                next[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && arr[i] <= arr[stack.peek()]) {
                pre[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += (long) (i - pre[i]) * (next[i] - i) % (1000000007) * arr[i] % (1000000007);
            result %= 1000000007;
        }
        return result;
    }
}
