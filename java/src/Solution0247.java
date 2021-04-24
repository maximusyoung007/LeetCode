import java.util.*;

/**
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 *
 * 找到所有长度为 n 的中心对称数。
 *
 * 示例 :
 *
 * 输入:  n = 2
 * 输出: ["11","69","88","96"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strobogrammatic-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0247 {
    public List<String> findStrobogrammatic(int n) {
        List<String> t = Arrays.asList("0", "1", "8");
        List<String> t2 = Arrays.asList("69", "96", "00", "11", "88");
        Map<String, String> m = new HashMap() {{
            put("6", "9");
            put("9", "6");
            put("1", "1");
            put("8", "8");
            put("0", "0");
        }};
        List<String> result = new ArrayList<>();
        if (n == 1) {
            return t;
        }
        else if (n == 2) {
            return Arrays.asList("69", "96", "11", "88");
        }
        else {
            if (n % 2 == 0) {
                for (String ts : t2) {
                    dfs(result, ts, m, n);
                }
            }
            if (n % 2 == 1) {
                for (String ts : t) {
                    dfs(result, ts, m, n);
                }
            }
        }
        return result;
    }
    void dfs(List<String> res, String t, Map<String, String> map, int n) {
        if (t.length() == n) {
            res.add(t);
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals("0")) {
                if (t.length() == n - 2) {
                    continue;
                }
            }
            String t2 = entry.getKey() + t + entry.getValue();
            dfs(res, t2, map, n);
        }
    }
}
