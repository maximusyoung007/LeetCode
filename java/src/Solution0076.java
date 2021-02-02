import java.util.HashMap;
import java.util.Map;

public class Solution0076 {
    String minWindow(String s, String t) {
        if(s.equals("") || t.equals("")) return "";
        if(s.length() < t.length()) return "";
        if(s.equals(t))return s;
        int left = 0, right = 0, minLeft = 0, minRight = 0;
        int min = s.length() + 1;
        Map<Character, Integer> m1 = new HashMap<>();
        int count = t.length();
        for (int i = 0; i < t.length(); i++) {
            if (!m1.containsKey(t.charAt(i))) {
                m1.put(t.charAt(i),1);
            }
            else {
                m1.put(t.charAt(i),m1.get(t.charAt(i)) + 1);
            }
        }

        while(right < s.length()) {
            if(m1.containsKey(s.charAt(right))) {
                if(m1.get(s.charAt(right)) > 0) {
                    m1.put(s.charAt(right),m1.get(s.charAt(right)) - 1);
                    count--;
                } else if(m1.get(s.charAt(right)) <= 0){
                    m1.put(s.charAt(right),m1.get(s.charAt(right)) - 1);
                }
            }
            right++;
            while(count == 0) {
                if(right - left < min) {
                    minLeft = left;
                    minRight = right;
                    min = right - left;
                }
                if(m1.containsKey(s.charAt(left))) {
                    if(m1.get(s.charAt(left)) < 0) {
                        m1.put(s.charAt(left), m1.get(s.charAt(left)) + 1);
                    } else if(m1.get(s.charAt(left)) >= 0) {
                        m1.put(s.charAt(left), m1.get(s.charAt(left)) + 1);
                        count++;
                    }
                }
                left++;
            }
        }
        String result = s.substring(minLeft, minRight);
        return result;
    }
}
