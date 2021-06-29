/**
 * 给你一个已经 排好序 的整数数组 nums 和整数 a、b、c。对于数组中的每一个数 x，计算函数值 f(x) = ax2 + bx + c，请将函数值产生的数组返回。
 *
 * 要注意，返回的这个数组必须按照 升序排列，并且我们所期望的解法时间复杂度为 O(n)。
 *
 * 示例 1：
 *
 * 输入: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
 * 输出: [3,9,15,33]
 * 示例 2：
 *
 * 输入: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
 * 输出: [-23,-5,1,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-transformed-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int[] result = new int[len];
        if (a == 0) {
            if (b > 0) {
                for (int i = 0; i < nums.length; i++) {
                    result[i] = nums[i] * b + c;
                }
            }
            else if (b < 0) {
                for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
                    result[j] = nums[i] * b + c;
                }
            } else {
                for (int i = 0; i < nums.length; i++) {
                    result[i] = c;
                }
            }
            return result;
        }
        else if (a > 0) {
            int i = len - 1;
            while (left <= right) {
                int leftVal = a * nums[left] * nums[left] + b * nums[left] + c;
                int rightVal = a * nums[right] * nums[right] + b * nums[right] + c;
                if (rightVal >= leftVal) {
                    result[i] = rightVal;
                    i--;
                    right--;
                } else if (leftVal > rightVal) {
                    result[i] = leftVal;
                    i--;
                    left++;
                }
            }
        }
        else if (a < 0) {
            int i = 0;
            while (left <= right) {
                int leftVal = a * nums[left] * nums[left] + b * nums[left] + c;
                int rightVal = a * nums[right] * nums[right] + b * nums[right] + c;
                if (rightVal <= leftVal) {
                    result[i] = rightVal;
                    i++;
                    right--;
                } else if (leftVal < rightVal) {
                    result[i] = leftVal;
                    i++;
                    left++;
                }
            }
        }
        return result;
    }
}
