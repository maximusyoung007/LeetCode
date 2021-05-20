import java.util.Arrays;

public class Solution0259 {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    result += k - j;
                    j += 1;
                } else {
                    k -= 1;
                }
            }
        }
        return result;
    }
}
