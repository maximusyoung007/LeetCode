package problemSolution;

public class Problem0009 {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int c = x,b = 0;
        while(x != 0) {
            int t = x % 10;
            b = b * 10 + t;
            x = x / 10;
        }
        if(c == b)
            return true;
        else return false;
    }
}
