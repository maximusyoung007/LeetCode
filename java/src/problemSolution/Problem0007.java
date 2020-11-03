package problemSolution;

public class Problem0007 {
    public int reverse(int x) {
        String s = String.valueOf(x);
        int t = 0;
        if(x < 0) {
            s = s.substring(1,s.length());
            t = -1;
        }
        String s1 = new StringBuffer(s).reverse().toString();
        Long l1 = Long.parseLong(s1);
        if(t == -1) {
            l1 = l1 * t;
            if(l1 < Integer.MIN_VALUE)
                return 0;
            else
                return l1.intValue();
        }
        else {
            if(l1 > Integer.MAX_VALUE)
                return 0;
            else
                return l1.intValue();
        }
    }
}
