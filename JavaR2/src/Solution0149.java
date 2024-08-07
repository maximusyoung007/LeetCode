import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/8/5      create
 */
public class Solution0149 {
	public int maxPoints(int[][] points) {
		Map<String, Integer> slopeMap = new HashMap<>();

		for (int i = 0; i < points.length; i++) {
			int[] point = points[i];
			int x = point[0];
			int y = point[1];

			for (int j = i+1; j < points.length; j++) {
				int[] point2 = points[j];
				int x2 = point2[0];
				int y2 = point2[1];

				String slope;
				if (y2 == y) {
					slope = "0_1";
				} else if (x2 == x) {
					slope = "1_0";
				} else {
					int a = y2 - y, b = x2 - x;
					int k = gcd(a, b);
					slope = (a / k) + "_" + (b / k);
				}


				slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
			}
		}

		int maxn = 0;
		for (Map.Entry<String, Integer> entry : slopeMap.entrySet()) {
			if (entry.getValue() > maxn) {
				maxn = entry.getValue();
			}
		}
		return maxn + 1;
	}

	int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}
