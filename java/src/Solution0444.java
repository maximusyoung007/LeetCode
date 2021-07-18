import java.util.*;

/**
 * 验证原始的序列 org 是否可以从序列集 seqs 中唯一地重建。
 * 序列 org 是 1 到 n 整数的排列，其中 1 ≤ n ≤ 104。
 * 重建是指在序列集 seqs 中构建最短的公共超序列。
 * （即使得所有  seqs 中的序列都是该最短序列的子序列）。确定是否只可以从 seqs 重建唯一的序列，且该序列就是 org 。
 *
 * 示例 1：
 *
 * 输入：
 * org: [1,2,3], seqs: [[1,2],[1,3]]
 *
 * 输出：
 * false
 *
 * 解释：
 * [1,2,3] 不是可以被重建的唯一的序列，因为 [1,3,2] 也是一个合法的序列。
 *  
 *
 * 示例 2：
 *
 * 输入：
 * org: [1,2,3], seqs: [[1,2]]
 *
 * 输出：
 * false
 *
 * 解释：
 * 可以重建的序列只有 [1,2]。
 *  
 *
 * 示例 3：
 *
 * 输入：
 * org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]
 *
 * 输出：
 * true
 *
 * 解释：
 * 序列 [1,2], [1,3] 和 [2,3] 可以被唯一地重建为原始的序列 [1,2,3]。
 *  
 *
 * 示例 4：
 *
 * 输入：
 * org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]
 *
 * 输出：
 * true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sequence-reconstruction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        boolean[] exist = new boolean[n+1];
        for (int i = 0; i < exist.length; i++) {
            exist[i] = false;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n + 1];
        for (int i = 0; i < inDegree.length; i++) {
            inDegree[i] = 0;
        }
        for (List<Integer> l : seqs) {
            int from = -1;
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i) <= 0 || l.get(i) > n) {
                    return false;
                }
                exist[l.get(i)] = true;
                if (from != -1) {
                    List<Integer> to = null;
                    if (graph.containsKey(from)) {
                        to = graph.get(from);
                    } else {
                        to = new ArrayList<>();
                    }
                    to.add(l.get(i));
                    graph.put(from, to);
                    inDegree[l.get(i)]++;
                }
                from = l.get(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (!exist[i]) {
                return false;
            }
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            //多个入度为0的点，错误
            if (queue.size() != 1) {
                return false;
            }
            int cur = queue.poll();
            if (cur != org[i++]) {
                return false;
            }
            if (graph.get(cur) != null) {
                for (int j = 0; j < graph.get(cur).size(); j++) {
                    inDegree[graph.get(cur).get(j)]--;
                    if (inDegree[graph.get(cur).get(j)] == 0) {
                        queue.add(graph.get(cur).get(j));
                    }
                }
            }
        }
        if (i != n) {
            return false;
        }
        return true;
    }
}
