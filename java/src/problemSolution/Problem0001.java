package problemSolution;

import java.util.HashMap;
import java.util.Map;

public class Problem0001 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0,j = 0;
        for(i = 0;i < nums.length;i++) {
            for(j = i + 1;j < nums.length;j++) {
                if(i != j && nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
