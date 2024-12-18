package solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution0433 {
	public int minMutation(String startGene, String endGene, String[] bank) {
//		if (judge(startGene, endGene)) {
//			return 1;
//		}

		Set<String> exist = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.add(startGene);

		int count = 1;
		int k = 1;
		while (!queue.isEmpty()) {
			for (int i = 0; i < k; i++) {
				String gene = queue.poll();
				int tk = 0;

				for (String s : bank) {
					//广度优先
					if (!exist.contains(s) && judge(gene, s)) {
						queue.add(s);
						exist.add(s);
						tk++;
						if (s.equals(endGene)) {
							return count;
						}
					}
				}

				k = tk;
			}
			//一层全部遍历完了，添加层数
			count++;
		}

		return -1;
	}

	public boolean judge(String gene1, String gene2) {
		int num = 0;
		for (int i = 0; i < gene1.length(); i++) {
			if (gene1.charAt(i) != gene2.charAt(i)) {
				num++;
			}
		}

		return num == 1;
	}
}
