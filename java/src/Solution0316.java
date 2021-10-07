import java.util.*;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 *
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 * 提示：
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            //当前元素没有入过栈
            if (!set.contains(s.charAt(i))) {
                //循环判断之前的是否比自己大，大的话就出栈，并且这个出栈的元素至少还剩一个
                while (!stack.isEmpty() && stack.peek() >= s.charAt(i) && map.get(stack.peek()) > 0) {
                    set.remove(stack.peek());
                    stack.pop();
                }
                stack.push(s.charAt(i));
                set.add(stack.peek());
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            } else {
                //当前元素已经入栈了，跳过这个元素，并且将剩余各数-1
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }



    /*
    * 关于如何比较两个字符串的字典序，方法是这样的：
    * 从左边第一位开始，如果两个串这一位上的字符不一样，则结束比较，这一位上字符小的串字典序更小，否则继续比较下一位。
    * 特殊的，如果比较至某一位时某个串比另一个串长度短提前结束，则长度短的串字典序更小。*/
//    public int minString(String s1, String s2) {
//        int len1 = s1.length();
//        int len2 = s2.length();
//        if (len1 < len2) {
//            return -1;
//        }
//        if (len2 < len1) {
//            return 1;
//        }
//        if (len1 == len2) {
//            for (int i = 0; i < len1; i++) {
//                char a1 = s1.charAt(i);
//                char a2 = s2.charAt(i);
//                if (a1 == a2) {
//                    continue;
//                } else if (a1 <= a2) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//        }
//        return -1;
//    }
}
