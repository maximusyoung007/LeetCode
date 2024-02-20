import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution0406 {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] p1, int[] p2) {
				if (p1[0] != p2[0]) {
					return p2[0] - p1[0];
				} else {
					return p1[1] - p2[1];
				}
			}
		});

		List<int[]> res = new LinkedList<>();
		for (int[] p : people) {
			res.add(p[1], p);
		}

		return res.toArray(new int[0][]);
	}
}
