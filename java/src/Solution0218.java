import java.util.*;
import java.util.stream.Collector;

/**
 * A city's skyline is the outer contour of the silhouette formed by
 * all the buildings in that city when viewed from a distance.
 * Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.
 * <p>
 * The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:
 * <p>
 * lefti is the x coordinate of the left edge of the ith building.
 * righti is the x coordinate of the right edge of the ith building.
 * heighti is the height of the ith building.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * <p>
 * The skyline should be represented as a list of "key points" sorted by their x-coordinate
 * in the form [[x1,y1],[x2,y2],...].
 * Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list,
 * which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends.
 * Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.
 * <p>
 * Note: There must be no consecutive horizontal lines of equal height in the output skyline.
 * For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable;
 * the three lines of height 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]
 * <p>
 * Example 1:
 * Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * Explanation:
 * Figure A shows the buildings of the input.
 * Figure B shows the skyline formed by those buildings.
 * The red points in figure B represent the key points in the output list.
 * <p>
 * Example 2:
 * Input: buildings = [[0,2,3],[2,5,3]]
 * Output: [[0,3],[5,0]]
 * <p>
 * Constraints:
 * 1 <= buildings.length <= 104
 * 0 <= lefti < righti <= 231 - 1
 * 1 <= heighti <= 231 - 1
 * buildings is sorted by lefti in non-decreasing order.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-skyline-problem
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//规则 1：如果是「从下到上」转向「水平方向」，纵坐标最大的点是关键点；
//规则 2：如果是「从上到下」转向「水平方向」，纵坐标第二大的点是关键点。
public class Solution0218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        Map<Integer, Integer> errorMap = new HashMap<>();
        List<int[]> points = new ArrayList<>();

        for (int i = 0; i < buildings.length; i++) {
            //左节点
            points.add(new int[]{buildings[i][0], -buildings[i][2]});
            //右节点
            points.add(new int[]{buildings[i][1], buildings[i][2]});
        }

        Collections.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) {
                    return -1;
                } else if (o1[0] > o2[0]) {
                    return 1;
                } else {
                    if (o1[1] < o2[1]) {
                        return -1;
                    }
                    return 1;
                }
            }
        });

        queue.add(0);
        int lastHeight = 0;

        for (int[] b : points) {
            //左节点参与竞争
            if (b[1] < 0) {
                queue.add(-b[1]);
            }
            //右节点删除
            else {
                errorMap.put(b[1], errorMap.getOrDefault(b[1], 0) + 1);
            }

            while (true) {
                int curHeight = queue.peek();
                if (errorMap.containsKey(curHeight)) {
                    if (errorMap.get(curHeight) == 1) {
                        errorMap.remove(curHeight);
                    } else {
                        errorMap.put(curHeight, errorMap.get(curHeight) - 1);
                    }
                    queue.poll();
                } else {
                    break;
                }
            }

            int curHeight = queue.peek();
            if (curHeight != lastHeight) {
                result.add(Arrays.asList(b[0], curHeight));
                lastHeight = curHeight;
            }

        }

        return result;
    }
}
