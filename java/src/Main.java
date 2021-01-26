public class Main {
    public static void main(String[] args) {
//        Solution0001 solution0001 = new Solution0001();
//        int[] nums = {3,3};
//        int[] result = solution0001.twoSum(nums,6);
//        for(int i : result) {
//            System.out.println(i);
//        }

        Solution0057 solution0057 = new Solution0057();
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newIntervals = {4,8};
        int[][] result = solution0057.insert(intervals,newIntervals);
        System.out.println(result);
    }
}
