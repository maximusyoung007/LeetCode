import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numStr = new String[n];
        for (int i = 0; i < n; i++) {
            numStr[i] = Integer.valueOf(nums[i]).toString();
        }
        Arrays.sort(numStr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String r1 = s1 + s2;
                String r2 = s2 + s1;
                return r2.compareTo(r1);
            }
        });
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < numStr.length; i++) {
            sb.append(numStr[i]);
        }
        int k = 0;
        while (k < n - 1) {
            if (sb.charAt(k) == '0') {
                k++;
            } else {
                break;
            }
        }
        return sb.substring(k);
    }
}
