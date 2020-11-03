package problemSolution;

import org.junit.Test;

import static org.junit.Assert.*;

public class Problem0007Test {

    @Test
    public void reverse() {
        Problem0007 problem0007 = new Problem0007();
        assertEquals(321,problem0007.reverse(123));
        assertEquals(21,problem0007.reverse(120));
        assertEquals(-321,problem0007.reverse(-123));
    }
}