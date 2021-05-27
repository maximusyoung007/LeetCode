import java.util.*;

/**
 * 给定一个字符串 s ，返回其通过重新排列组合后所有可能的回文字符串，并去除重复的组合。
 *
 * 如不能形成任何回文排列时，则返回一个空列表。
 *
 * 示例 1：
 *
 * 输入: "aabb"
 * 输出: ["abba", "baab"]
 *
 * 示例 2：
 *
 * 输入: "abc"
 * 输出: []
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0267 {
    public List<String> generatePalindromes(String s) {
        if (s.length() == 0) {
            return new ArrayList<>();
        }
        else if (s.length() == 1) {
            return new ArrayList() {{
                add(s);
            }};
        }
        else {
            Map<Character, Integer> map = new HashMap<>();
            List<Character> chars = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int count = 0;
            char mid = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    if (entry.getValue() == s.length()) {
                        return new ArrayList() {{
                            add(s);
                        }};
                    }
                    count++;
                    if (count > 1) {
                        return new ArrayList<>();
                    }
                    mid = entry.getKey();
                }
                if (entry.getValue() != 1) {
                    for (int i = 0; i < entry.getValue() / 2; i++) {
                        chars.add(entry.getKey());
                    }
                }

            }
            //对set作全排列
            StringBuilder curr = new StringBuilder();
            List<String> result = new ArrayList<>();
            int len = chars.size();
            List<Integer> used = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                used.add(0);
            }
            dfs(curr, used, chars, result);
            Set<String> set = new HashSet<>();
            set.addAll(result);
            List<String> r = new ArrayList<>();
            r.addAll(set);
            List<String> rr = new ArrayList<>();
            for (int i = 0; i < r.size(); i++) {
                String ts = r.get(i);
                String rts = new StringBuilder(ts).reverse().toString();
                String tr = "";
                if (s.length() % 2 == 0) {
                    tr = tr + ts + rts;
                } else {
                    tr = tr + ts + mid + rts;
                }
                rr.add(tr);
            }
            return rr;
        }
    }

    void dfs(StringBuilder curr, List<Integer> used, List<Character> chars, List<String> result) {
        if (curr.length() == chars.size()) {
            result.add(curr.toString());
            return;
        }
        for (int i = 0; i < chars.size(); i++) {
            if (used.get(i) == 0) {
                List<Integer> used2 = new ArrayList<>();
                for (int j = 0; j < used.size(); j++) {
                    if (j == i || used.get(j) == 1) {
                        used2.add(1);
                    } else {
                        used2.add(0);
                    }
                }
                curr.append(chars.get(i));
                dfs(curr, used2, chars, result);
                curr.replace(curr.length() - 1, curr.length(), "");
            }
        }
    }
}
