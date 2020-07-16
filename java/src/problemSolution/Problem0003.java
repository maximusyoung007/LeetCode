package problemSolution;

import java.util.HashSet;
import java.util.Set;

public class Problem0003 {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals(""))
            return 0;
        Set<Character> set = new HashSet<>();
        int max = 0,right = 0;
        for(int i = 0;i < s.length();i++) {
            int left = i;
            if(left != 0) {
                set.remove(s.charAt(i - 1));
            }
            while(right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            max = Math.max(max,set.size());
        }
        return max;
    }
}
