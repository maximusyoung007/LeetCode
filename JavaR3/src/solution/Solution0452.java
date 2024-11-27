package solution;

import java.util.Arrays;
import java.util.Comparator;

public class Solution0452 {
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0) {
			return 0;
		}

		Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

		int start = points[0][0], end = points[0][1];

		int res = 0;

		for (int i = 1; i < points.length; i++) {
			if (points[i][0] <= end) {
				//如果有交集，则合并, 取一个尽可能小的区间
				start = Math.max(start, points[i][0]);
				end = Math.min(end, points[i][1]);
			} else {
				//没有交集，之前合并好的作为一个整体+1，当前区间作为新的合并区间的开始
				res++;
				start = points[i][0];
				end = points[i][1];
			}
		}

		res++;

		return res;
	}
}
