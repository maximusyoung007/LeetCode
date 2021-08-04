import java.util.ArrayList;
import java.util.List;

public class Solution0228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int left = 0, right = 0;
        int n = nums.length;
        while (right < n) {
            if (right + 1 >= n || nums[right] + 1 != nums[right + 1]) {
                String ts = "";
                if (nums[left] != nums[right]) {
                    ts = nums[left] + "->" + nums[right];
                } else {
                    ts = String.valueOf(nums[left]);
                }
                result.add(ts);
                left = right + 1;
            }
            right++;
        }
        return result;
    }
}
