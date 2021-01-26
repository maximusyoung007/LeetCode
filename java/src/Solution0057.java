import java.util.ArrayList;
import java.util.List;

public class Solution0057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int first = 0;
        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
            } else if(intervals[i][0] > newInterval[1]) {
                if(first == 0) {
                    result.add(newInterval);
                    first = 1;
                }
                result.add(intervals[i]);
            } else {
                newInterval[0] = intervals[i][0] <= newInterval[0] ? intervals[i][0] : newInterval[0];
                newInterval[1] = intervals[i][1] >= newInterval[1] ? intervals[i][1] : newInterval[1];
            }
        }
        if(first == 0) {
            result.add(newInterval);
        }
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); ++i) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
