import java.util.Arrays;
import java.util.Comparator;

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
		return people;
	}
}
