package solution;

import java.util.Arrays;
import java.util.Comparator;

public class Solution0056 {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

		int start = intervals[0][0], end = intervals[0][1];
		int[][] merge = new int[intervals.length][2];
		int k = 0;

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] <= intervals[i-1][1]) {
				end = Math.max(intervals[i][1], intervals[i - 1][1]);
				intervals[i][1] = end;
			} else {
				merge[k++] = new int[] {start, end};
				start = intervals[i][0];
				end = intervals[i][1];
			}

		}

		merge[k++] = new int[] {start, end};

		merge = Arrays.copyOf(merge, k);

		return merge;
	}
}
