public class Solution1184 {
	public int distanceBetweenBusStops(int[] distance, int start, int destination) {
		if (start > destination) {
			int temp = destination;
			destination = start;
			start = temp;
		}
		int sum = 0, sum1 = 0;
		for (int i = 0; i < distance.length; i++) {
			if (i >= start && i < destination) {
				sum1 += distance[i];
			}
			sum += distance[i];
		}
		int sum2 = sum - sum1;
		return Math.min(sum1, sum2);
	}
}
