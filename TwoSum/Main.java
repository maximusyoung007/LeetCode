package TwoSum;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int[] result = new int[2];
        result = Solution.twoSum(nums,9);
        for(int i = 0;i < 2;i++)
            System.out.println(result[i]);
    }
}
