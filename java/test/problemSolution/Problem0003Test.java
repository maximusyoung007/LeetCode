package problemSolution;

import org.junit.Test;

import static org.junit.Assert.*;

public class Problem0003Test {

    @Test
    public void lengthOfLongestSubstring() {
        Problem0003 problem0003 = new Problem0003();
        String s1 = "abcabcbb";
        assertEquals(3,problem0003.lengthOfLongestSubstring(s1));

        String s2 = "bbbbb";
        assertEquals(1,problem0003.lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        assertEquals(3,problem0003.lengthOfLongestSubstring(s3));

        String s4 = "dvdf";
        assertEquals(3,problem0003.lengthOfLongestSubstring(s4));

        String s5 = " ";
        assertEquals(1,problem0003.lengthOfLongestSubstring(s5));
    }
}