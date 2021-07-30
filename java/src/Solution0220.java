import java.util.Set;
import java.util.TreeSet;

/**
 * Given an integer array nums and two integers k and t,
 * return true if there are two distinct indices i and j in the array such that abs(nums[i] - nums[j]) <= t
 * and abs(i - j) <= k.
 *
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 *  
 * Constraints:
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 */
public class Solution0220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            //ceiling方法查找大于等于 x - t 的最小的元素 y，如果 y 存在，且 y≤x+t，我们就找到了一对符合条件的元素。
            Long ceiling = treeSet.ceiling((long)nums[i] - (long)t);
            if (ceiling != null && ceiling <= (long)nums[i] + (long) t) {
                return true;
            }
            treeSet.add((long) nums[i]);
            if (treeSet.size() > k) {
                treeSet.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
