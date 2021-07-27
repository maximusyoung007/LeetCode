/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have a security system connected,
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 *
 * Example 2:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Example 3:
 * Input: nums = [0]
 * Output: 0
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//原来的数组分为1～n-1和2～n两个数组，分别对两个数组使用动态规划
public class Solution0213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] nums1 = new int[n - 1];
        int[] nums2 = new int[n - 1];
        System.arraycopy(nums, 0, nums1, 0, n - 1);
        System.arraycopy(nums, 1, nums2, 0, n - 1);
        //抢劫所获最大收入
        int[] rob = new int[n];
        //不抢劫所获最大收入
        int[] noRob = new int[n];
        int max1 = 0, max2 = 0;
        rob[0] = nums1[0];
        noRob[0] = 0;
        max1 = rob[0];
        for (int i = 1; i < n - 1; i++) {
            rob[i] = noRob[i - 1] + nums1[i];
            noRob[i] = Math.max(noRob[i - 1], rob[i - 1]);
            max1 = Math.max(Math.max(rob[i], noRob[i]), max1);
        }
        for (int i = 0; i < n; i++) {
            rob[i] = 0;
            noRob[i] = 0;
        }
        rob[0] = nums2[0];
        noRob[0] = 0;
        max2 = rob[0];
        for (int i = 1; i < n - 1; i++) {
            rob[i] = noRob[i - 1] + nums2[i];
            noRob[i] = Math.max(noRob[i - 1], rob[i - 1]);
            max2 = Math.max(Math.max(rob[i], noRob[i]), max1);
        }
        return Math.max(max1, max2);
    }
}
