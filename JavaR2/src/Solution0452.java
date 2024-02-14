import java.util.Arrays;
import java.util.Comparator;

/**
 * @author maximusyoung
 */
public class Solution0452 {
	public int findMinArrowShots(int[][] points) {
		int length = points.length;
		if (length == 1) {
			return 1;
		}
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] point1, int[] point2) {
				//return point1[1] - point2[1];
				return Integer.compare(point1[1], point2[1]);
			}
		});

		int i = 0, j = 1;
		int count = 0;
		while (i < length && j < length) {
			if (j == length - 1) {
				count++;
			}
			if (points[j][0] <= points[i][1]) {
				j++;
			} else {
				//开始新一轮的贪心
				count++;
				i = j;
				j = i + 1;
			}
		}
		return count;
	}
}
