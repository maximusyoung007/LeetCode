import java.util.*;

/**
 * 给你一个非空的字符串 s 和一个整数 k，你要将这个字符串中的字母进行重新排列，使得重排后的字符串中相同字母的位置间隔距离至少为 k。
 *
 * 所有输入的字符串都由小写字母组成，如果找不到距离至少为 k 的重排结果，请返回一个空字符串 ""。
 *
 * 示例 1：
 *
 * 输入: s = "aabbcc", k = 3
 * 输出: "abcabc"
 * 解释: 相同的字母在新的字符串中间隔至少 3 个单位距离。
 * 示例 2:
 *
 * 输入: s = "aaabc", k = 3
 * 输出: ""
 * 解释: 没有办法找到可能的重排结果。
 * 示例 3:
 *
 * 输入: s = "aaadbbcc", k = 2
 * 输出: "abacabcd"
 * 解释: 相同的字母在新的字符串中间隔至少 2 个单位距离。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rearrange-string-k-distance-apart
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0358 {
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>((x, y) -> (y.getValue() - x.getValue()));
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        heap.addAll(map.entrySet());
        String result = "";
        if (k == 0) {
            return s;
        }
        if (heap.size() < k) {
            return result;
        }
        while (!heap.isEmpty()) {
            Map.Entry<Character, Integer> entry = heap.poll();
            result += entry.getKey();
            entry.setValue(entry.getValue() - 1);
            queue.add(entry);
            if (queue.size() == k) {
                Map.Entry<Character, Integer> entry1 = queue.poll();
                if (entry1.getValue() > 0) {
                    heap.add(entry1);
                }
            }
        }
        return result.length() == s.length() ? result : "";
    }
}
