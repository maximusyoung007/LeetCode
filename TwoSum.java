//0001
import java.util.HashMap;
import java.util.Map;
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] b = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < len;i++){
            map.put(nums[i],i);
        }
        for(int i = 0;i < len;i++){
            int j = target - nums[i];
            if(map.containsKey(j) && map.get(j) != i){
                b[0] = i;
                b[1] = map.get(j);
                break;
            }
        }
        return b;
    }
}
