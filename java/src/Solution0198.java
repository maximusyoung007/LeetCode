/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Example 2:
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 两个数组，一个数组记录抢劫这个房子能获得的最大收入，第二个数组记录不抢劫这个房子获得的最大收入，动态规划的思想，第一个数组初始为nums[0],第二个数组初始为0，状态转移方程：
 * 抢劫获得的最大收入=上次不抢劫获得的最大收入+这个房子的收入；
 * 不抢劫获得的最大收入=上次不抢劫获得的最大收入、上次抢劫获得的最大收入、现有的最大收入三者最大的那个
 */
public class Solution0198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 1) {
            return 0;
        }
        //抢劫所获最大收入
        int[] rob = new int[n];
        //不抢劫所获最大收入
        int[] noRob = new int[n];
        int max = 0;
        rob[0] = nums[0];
        noRob[0] = 0;
        max = rob[0];
        for (int i = 1; i < n; i++) {
            rob[i] = noRob[i - 1] + nums[i];
            noRob[i] = Math.max(noRob[i - 1], rob[i - 1]);
            max = Math.max(Math.max(rob[i], noRob[i]), max);
        }
        return max;
    }
}
