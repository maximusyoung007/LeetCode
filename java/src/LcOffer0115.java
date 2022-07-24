import java.util.*;

public class LcOffer0115 {
	public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
		int n = nums.length;
		int[] index = new int[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < sequences.length; i++) {
			for (int j = 0, k = 1; k < sequences[i].length; j++, k++) {
				List<Integer> t = map.containsKey(sequences[i][j]) ? map.get(sequences[i][j]) : new ArrayList<>();
				if (!t.contains(sequences[i][k])) {
					t.add(sequences[i][k]);
					index[sequences[i][k]] += 1;
				}
				map.put(sequences[i][j], t);
			}
		}


		int count = 0;
		for (int i = 1; i < index.length; i++) {
			if (index[i] == 0) {
				queue.add(i);
				count++;
				if (count == 2) {
					return false;
				}
			}
		}

		count = 0;

		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			int u = queue.poll();
			result.add(u);
			List<Integer> t = map.get(u);
			if (t != null) {
				for (int i = 0; i < t.size(); i++) {
					index[t.get(i)]--;
					if (index[t.get(i)] == 0) {
						count++;
						//有两个或以上入度为0的节点，则表示序列不唯一
						if (count == 2) {
							return false;
						}
						queue.add(t.get(i));
					}
				}
				count = 0;
			}
		}
		if (result.size() != nums.length) {
			return false;
		}
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i) != nums[i]) {
				return false;
			}
		}
		return true;
	}
}
