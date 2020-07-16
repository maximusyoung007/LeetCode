package problemSolution;

import static org.junit.Assert.*;
import org.junit.*;

public class Problem0001Test {

    @Test
    public void twoSum() {
        Problem0001 problem0001 = new Problem0001();
        int target = 9;
        int[] nums = {2,7,11,15};
        int[] result = {0,1};
        assertArrayEquals(result,problem0001.twoSum(nums,target));
    }
}