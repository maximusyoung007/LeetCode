import java.util.HashMap;
import java.util.Map;

/**
 * 在一个二维平面空间中，给你 n 个点的坐标。问，是否能找出一条平行于 y 轴的直线，让这些点关于这条直线成镜像排布？
 *
 * 注意：题目数据中可能有重复的点。

 * 进阶：你能找到比 O(n2) 更优的解法吗?
 *
 * 示例 1：
 * 输入：points = [[1,1],[-1,1]]
 * 输出：true
 * 解释：可以找出 x = 0 这条线。
 * 示例 2：
 *
 * 输入：points = [[1,1],[-1,-1]]
 * 输出：false
 * 解释：无法找出这样一条线。
 *  
 * 提示：
 *
 * n == points.length
 * 1 <= n <= 10^4
 * -10^8 <= points[i][j] <= 10^8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/line-reflection
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0356 {
    public boolean isReflected(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] < min) {
                min = points[i][0];
            }
            if (points[i][0] > max) {
                max = points[i][0];
            }
            map.put(points[i][0], points[i][1]);
        }
        int sum = min + max;
        for (int i = 0; i < points.length; i++) {
            //如果没有对称的key或者对称的key不一样高
            if (!map.containsKey(sum - points[i][0]) || !map.get(sum - points[i][0]).equals(map.get(points[i][0]))) {
                return false;
            }
        }
        return true;
    }
}
