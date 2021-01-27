import java.util.ArrayList;
import java.util.List;

public class Solution0060 {
    public String getPermutation(int n, int k) {
        k -= 1;
        String result = "";
        List<Integer> l = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            l.add(i);
        }
        for(int i = n - 1; i >= 0; i--) {
            int quotient = k / calFal(i);
            Integer num = l.get(quotient);
            result += num.toString();
            l.removeIf(v -> v == num);
            k = k % calFal(i);
        }
        return result;
    }

    public static int calFal(int n) {
        if(n == 0) {
            return 1;
        }
        int result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
