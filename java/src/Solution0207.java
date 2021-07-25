import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
 * that you must take course bi first if you want to take course ai.
 *
 *     For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 *
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0,
 * and to take course 0 you should also have finished course 1. So it is impossible.
 *
 * Constraints:
 *
 *     1 <= numCourses <= 105
 *     0 <= prerequisites.length <= 5000
 *     prerequisites[i].length == 2
 *     0 <= ai, bi < numCourses
 *     All the pairs prerequisites[i] are unique.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        for (int i = 0; i < inDegrees.length; i++) {
            inDegrees[i] = 0;
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] t = prerequisites[i];
            List<Integer> tl;
            if (graph.containsKey(t[1])) {
                tl = graph.get(t[1]);
                tl.add(t[0]);
            } else {
                tl = new ArrayList() {{
                    add(t[0]);
                }};
            }
            graph.put(t[1], tl);
            inDegrees[t[0]]++;
        }
        Queue<Integer> degreeQueue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                degreeQueue.add(i);
            }
        }
        while (!degreeQueue.isEmpty()) {
            int t = degreeQueue.poll();
            numCourses--;
            if (graph.containsKey(t)) {
                List<Integer> l = graph.get(t);
                for (Integer i : l) {
                    if (inDegrees[i] >= 1) {
                        inDegrees[i]--;
                    }
                    if (inDegrees[i] == 0) {
                        degreeQueue.add(i);
                    }
                }
            }
        }
        return numCourses == 0;
    }
}
