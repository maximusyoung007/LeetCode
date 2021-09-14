import java.util.*;

/**
 * 给你`一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * 示例 1：
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素

 * 示例 2：
 * 输入：nums = [-1]
 * 输出：[0]

 * 示例 3：
 * 输入：nums = [-1,-1]
 * 输出：[0,0]
 *  
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0315 {
    int n;
    int[] tree;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return result;
        }
        int[] t = new int[len];
        for (int i = 0; i < nums.length; i++) {
            t[i] = nums[i];
        }
        Arrays.sort(t);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer num : t) {
            map.put(num, rank);
            rank++;
        }
        n = len + 1;
        tree = new int[n];

        for (int i = len - 1; i >= 0; i--) {
            rank = map.get(nums[i]);
            update(rank, 1);
            result.add(sum(rank - 1));
        }
        Collections.reverse(result);
        return result;
    }

    int lowbit(int x) {
        return x & (-x);
    }

    void update(int index, int val) {
        while (index < n) {
            tree[index] += val;
            index += lowbit(index);
        }
    }

    int sum(int i) {
        int s = 0;
        while (i > 0) {
            s += tree[i];
            i -= lowbit(i);
        }
        return s;
    }
}
