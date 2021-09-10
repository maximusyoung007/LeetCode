public class Solution0326 {
    public boolean isPowerOfThree(int n) {
        if (n == 1) return true;
        if (n < 3) return false;
        while (n >= 3 && n % 3 == 0) {
            n /= 3;
        }
        if (n == 1) return true;
        else return false;
    }
}
