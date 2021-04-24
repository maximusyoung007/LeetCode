import java.util.*;

/**
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 *
 * 写一个函数来计算范围在 [low, high] 之间中心对称数的个数。
 *
 * 示例:
 *
 * 输入: low = "50", high = "100"
 * 输出: 3
 * 解释: 69，88 和 96 是三个在该范围内的中心对称数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strobogrammatic-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0248 {
    public int strobogrammaticInRange(String low, String high) {
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
        for (int n = low.length(); n <= high.length(); n++) {
            List<String> partResult = new ArrayList<>();
            if (n == 1) {
                partResult = t;
            } else if (n == 2) {
                partResult = Arrays.asList("69", "96", "11", "88");
            } else {
                if (n % 2 == 0) {
                    for (String ts : t2) {
                        dfs(partResult, ts, m, n);
                    }
                }
                if (n % 2 == 1) {
                    for (String ts : t) {
                        dfs(partResult, ts, m, n);
                    }
                }
            }
            result.addAll(partResult);
        }
        int count = 0;
        for (String s : result) {
            Long tl = Long.parseLong(s);
            if (tl >= Long.parseLong(low) && tl <= Long.parseLong(high)) {

            }
        }
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
