import java.util.ArrayList;
import java.util.List;

public class Solution0254 {
    ArrayList<Integer> partResult = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
        dfs(n, 2);
        return result;
    }

    void dfs(int n, int s) {
        if (n < s) {
            return;
        }
        int i = s;
        int tSize = partResult.size();
        while (i * i <= n) {
            if (n % i == 0) {
                int t = n / i;
                partResult.add(i);
                partResult.add(t);
                result.add((ArrayList) partResult.clone());
                partResult.remove(partResult.size() - 1);
                dfs(t, i);
                partResult = new ArrayList<>(partResult.subList(0, tSize));
            }
            i++;
        }
    }
}
