import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
 * that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses.
 * If there are many valid answers, return any of them.
 * If it is impossible to finish all courses, return an empty array.
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *  
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        List<Integer> r1 = new ArrayList<>();
        while (!degreeQueue.isEmpty()) {
            int t = degreeQueue.poll();
            numCourses--;
            r1.add(t);
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
        int[] result = new int[r1.size()];
        if (numCourses == 0) {
            for (int i = 0; i < r1.size(); i++) {
                result[i] = r1.get(i);
            }
            return result;
        }
        return new int[0];
    }
}
