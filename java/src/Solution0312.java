import java.util.ArrayList;
import java.util.List;

public class Solution0312 {
	int[][] dp;
	List<Integer> numList = new ArrayList<>();
	public int maxCoins(int[] nums) {
		numList.add(1);
		for (int i = 0; i < nums.length; i++) {
			numList.add(nums[i]);
		}
		numList.add(1);

		int len = numList.size();
		dp = new int[len][len];

		for (int i = 2; i < numList.size(); i++) {
			for (int j = 0; j + i < numList.size(); j++) {
				//计算dp[j][j+i]
				calRange(j, j + i);
			}
		}
		return dp[0][len - 1];
	}

	public void calRange(int i, int j) {
		int max = 0;
		for (int k = i + 1; k < j; k++) {
			max = dp[i][k] + dp[k][j] + numList.get(i) * numList.get(j) * numList.get(k);
			if (dp[i][j] < max) {
				dp[i][j] = max;
			}
		}
	}
}