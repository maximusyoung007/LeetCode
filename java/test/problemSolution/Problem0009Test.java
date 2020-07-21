package problemSolution;

import static org.junit.Assert.*;
import org.junit.*;

public class Problem0009Test {

    @Test
    public void isPalindrome() {
        Problem0009 problem0009 = new Problem0009();
        assertEquals(true,problem0009.isPalindrome(121));
        assertEquals(false,problem0009.isPalindrome(10));
    }
}