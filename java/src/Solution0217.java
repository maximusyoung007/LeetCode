import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 *
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *  
 * Constraints:
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0217 {
    public boolean containDuplicate(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : nums) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        if (countMap.size() != nums.length) {
            return true;
        } else {
            return false;
        }
    }
}
