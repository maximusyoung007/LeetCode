import java.util.*;

/**
 * 给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。这样，我们可以持续进行 “移位” 操作，从而生成如下移位序列：
 *
 * "abc" -> "bcd" -> ... -> "xyz"
 *
 * 给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。
 *
 *
 *
 * 示例：
 *
 * 输入：["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
 * 输出：
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 * 解释：可以认为字母表首尾相接，所以 'z' 的后续为 'a'，所以 ["az","ba"] 也满足 “移位” 操作规律。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-shifted-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0249 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> mapList = new HashMap<>();
        for (String s : strings) {
            //产生以'a'为开头的key
            String key = changeToStartWithA(s);
            if (!mapList.containsKey(key)) {
                List<String> l = new ArrayList(){{
                    add(s);
                }};
                mapList.put(key, l);
            } else {
                List<String> l = mapList.get(key);
                l.add(s);
                mapList.put(key, l);
            }
        }
        for (Map.Entry<String, List<String>> entry : mapList.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public String changeToStartWithA(String s1) {
        int a1 = s1.charAt(0) - 'a';
        int dis = a1 - 97;
        String key = "a";
        for (int i = 1; i < s1.length(); i++) {
            int t = s1.charAt(i) - 'a' - dis;
            Character tc = t >= 97 ? (char)t : (char)(t + 26);
            key = key + tc.toString();
        }
        return key;
    }
}
