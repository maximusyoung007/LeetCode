import java.util.HashMap;
import java.util.Map;

public class Solution0290 {
    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        if (pattern.length() != ss.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char tc = pattern.charAt(i);
            String ts = ss[i];
            if (map.containsKey(tc)) {
                if (!map.get(tc).equals(ts)) return false;
            } else {
                //tc 和ts对应，但是存在一个ts，不和tc对应，错误
                if (map2.containsKey(ts) && map2.get(ts) != tc) {
                    return false;
                }
                map.put(tc, ts);
                map2.put(ts, tc);
            }
        }
        return true;
    }
}
