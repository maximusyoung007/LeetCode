/**
 * @author maximusyoung
 *
 */
public class Solution0605 {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int length = flowerbed.length;
		int count = 0;
		if (length == 1 && flowerbed[0] == 0) {
			count = 1;
			return count >= n;
		}
		for (int i = 0; i < length; i++) {
			if (i == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0) {
				count++;
				flowerbed[i] = 1;
			}

			if (i == length - 1 && flowerbed[i] == 0 && flowerbed[i-1] == 0) {
				count++;
				flowerbed[i] = 1;
			}

			if (i > 0 && i < length - 1 && flowerbed[i-1] == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0) {
				count++;
				flowerbed[i] = 1;
			}
		}
		return count >= n;
	}
}
