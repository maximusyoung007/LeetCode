import java.util.Arrays;

/**
 * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k​​​​​​​ 个更新的操作。
 * <p>
 * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
 * <p>
 * 请你返回 k 次操作后的数组。
 * <p>
 * 示例:
 * <p>
 * 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * 输出: [-2,0,3,5,3]
 * 解释:
 * <p>
 * 初始状态:
 * [0,0,0,0,0]
 * <p>
 * 进行了操作 [1,3,2] 后的状态:
 * [0,2,2,2,0]
 * <p>
 * 进行了操作 [2,4,3] 后的状态:
 * [0,2,5,5,3]
 * <p>
 * 进行了操作 [0,2,-2] 后的状态:
 * [-2,0,3,5,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-addition
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        //a表示每个位置比前一个位置多的数
        int[] a = new int[length];
        Arrays.fill(a, 0);
        for (int i = 0; i < updates.length; i++) {
            a[updates[i][0]] += updates[i][2];
            if (updates[i][1] + 1 < length) {
                a[updates[i][1] + 1] -= -updates[i][2];
            }
        }
        for (int i = 1; i < length; i++) {
            a[i] += a[i - 1];
        }
        return a;
    }
}
