/**
 * 给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。
 *
 * 实现 NumArray 类：
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值更新为 val
 * int sumRange(int left, int right) 返回子数组 nums[left, right] 的总和（即，nums[left] + nums[left + 1], ..., nums[right]）
 *  
 *
 * 示例：
 * 输入：
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * 输出：
 * [null, 9, null, 8]
 * 解释：
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // 返回 9 ，sum([1,3,5]) = 9
 * numArray.update(1, 2);   // nums = [1,2,5]
 * numArray.sumRange(0, 2); // 返回 8 ，sum([1,2,5]) = 8
 *
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * 0 <= index < nums.length
 * -100 <= val <= 100
 * 0 <= left <= right < nums.length
 * 最多调用 3 * 104 次 update 和 sumRange 方法
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-mutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0307 {
    public static void main(String[] args) {
        NumArray0307 numArray = new NumArray0307(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(1, 2));
        System.out.println(numArray.sumRange(2, 2));
        System.out.println(numArray.sumRange(0, 0));
        System.out.println(numArray.sumRange(0, 1));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}

class NumArray0307 {
    int[] tree;
    int[] nums;
    int len;

    int lowbit(int x) {
        return x & (-x);
    }

    public NumArray0307(int[] nums) {
        this.nums = nums;
        len = nums.length;
        tree = new int[len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j += lowbit(j)) {
                tree[j] += nums[i];
            }
        }
    }

    public void update(int index, int val) {
        int sub = val - nums[index];
        for (int i = index + 1; i <= len; i += lowbit(i)) {
            tree[i] += sub;
        }
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int suml = 0;
        while (left > 0) {
            suml += tree[left];
            left -= lowbit(left);
        }

        int sumr = 0;
        right += 1;
        while (right > 0) {
            sumr += tree[right];
            right -= lowbit(right);
        }
        return sumr - suml;
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */