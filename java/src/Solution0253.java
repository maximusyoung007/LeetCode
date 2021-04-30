import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/meeting-rooms-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Queue<Integer> minPriorityQueue = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            if (minPriorityQueue.size() == 0) {
                minPriorityQueue.add(intervals[i][1]);
            } else {
                int peek = minPriorityQueue.peek();
                if (intervals[i][0] >= peek) {
                    minPriorityQueue.remove(peek);
                }
                minPriorityQueue.add(intervals[i][1]);
            }
        }
        return minPriorityQueue.size();
    }
}
