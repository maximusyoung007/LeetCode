package com.maximus.medium;

import java.util.HashMap;
import java.util.Map;
//动态规划
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0)
            return 0;
        int[] dp = new int[len];
        Map<Character, Integer> map = new HashMap<>();
        dp[0] = 1;
        char c0 = s.charAt(0);
        map.put(c0,0);
        for(int i = 1;i < len;i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                dp[i] = dp[i - 1] + 1;
            }
            else {
                int index = map.get(c);
                int d = i - index;
                if(d <= dp[i-1])
                    dp[i] = d;
                else
                    dp[i]  = dp[i - 1] + 1;
            }
            map.put(c,i);
        }
        int max = 0;
        for(int i = 0;i < len;i++) {
            if(dp[i] > max)
                max = dp[i];
        }
        return max;
    }
}
