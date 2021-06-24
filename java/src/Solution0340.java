import java.util.*;

/**
 * 给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
 *
 * 示例 1:
 *
 * 输入: s = "eceba", k = 2
 * 输出: 3
 * 解释: 则 T 为 "ece"，所以长度为 3。
 * 示例 2:
 *
 * 输入: s = "aa", k = 1
 * 输出: 2
 * 解释: 则 T 为 "aa"，所以长度为 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-most-k-distinct-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0340 {
    //滑动窗口，key字母对应value下标，下标装在队列里，left移动时出队，队列为空时，就表示没有这个字母了
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s == "") {
            return 0;
        }
        int len = 0, maxLen = 0;
        int left = 0, right = 0;
        Map<Character, Queue<Integer>> hashMap = new HashMap<>();
        Queue<Integer> queue;
        while (right < s.length()) {
            queue = hashMap.getOrDefault(s.charAt(right), new LinkedList<>());
            queue.add(right);
            hashMap.put(s.charAt(right), queue);
            if (hashMap.size() <= k) {
                len = right - left + 1;
                if (len > maxLen) {
                    maxLen = len;
                }
            }
            while (hashMap.size() > k) {
                if (hashMap.containsKey(s.charAt(left))) {
                    queue = hashMap.get(s.charAt(left));
                    queue.poll();
                }
                if (queue.isEmpty()) {
                    hashMap.remove(s.charAt(left));
                }
                left++;
                if (hashMap.size() <= k) {
                    len = right - left + 1;
                    if (len > maxLen) {
                        maxLen = len;
                    }
                }

            }
            right++;
        }
        return maxLen;
    }
}
