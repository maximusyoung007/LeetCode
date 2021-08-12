/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 原数组：       [1       2       3       4]
 * 左部分的乘积：   1       1      1*2    1*2*3
 * 右部分的乘积： 2*3*4    3*4      4      1
 * 结果：        1*2*3*4  1*3*4   1*2*4  1*2*3*1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int l = 1, r = 1;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                l = l * nums[i - 1];
            }
            //左边的所有乘积
            result[i] = l;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1) {
                r = r * nums[i + 1];
            }
            //乘右边的所有乘积
            result[i] = result[i] * r;
        }
        return result;
    }

}
