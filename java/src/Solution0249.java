import java.util.*;

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
