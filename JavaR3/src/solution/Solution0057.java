package solution;

import java.util.Arrays;

public class Solution0057 {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int start = newInterval[0], end = newInterval[1];

		if (intervals.length == 0) {
			return new int[][] {newInterval};
		}

		int i = 0;

		int[][] merge = new int[intervals.length+1][2];
		int k = 0;

		//找到需要和newInterval合并的区间，合并后作为一个整体插入，剩下的依次插入即可
		while (i < intervals.length) {
			//没有交集了, newInterval在当前区间之前
			if (end < intervals[i][0]) {
				merge[k++] = new int[] {start, end};
				merge[k++] = new int[] {intervals[i][0], intervals[i][1]};
				i++;
				break;
			} else if (start > intervals[i][1]) {
				//也没有交集， newInterval在当前区间之后
				merge[k++] = new int[] {intervals[i][0], intervals[i][1]};
			} else {
				//有交集，把两个合并成一个, 继续和下一个比较
				start = Math.min(intervals[i][0], start);
				end = Math.max(intervals[i][1], end);
			}
			i++;
		}

		while (i < intervals.length) {
			merge[k++] = new int[] {intervals[i][0], intervals[i][1]};
			i++;
		}


		if (end >= intervals[intervals.length-1][1]) {
			merge[k++] = new int[] {start, end};
		}

		return Arrays.copyOf(merge, k);
	}
}
