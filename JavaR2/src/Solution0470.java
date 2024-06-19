import java.util.Random;

/**
 * 已知 rand_N() 可以等概率的生成[1, N]范围的随机数
 * 那么：
 * (rand_X() - 1) × Y + rand_Y() ==> 可以等概率的生成[1, X * Y]范围的随机数
 * 即实现了 rand_XY()
 */
public class Solution0470 extends SolBase {
	public int rand10() {
		while(true) {
			//生成等概率 rand_49
			int num = (rand7() - 1) * 7 + rand7();
			//拒绝采样，如果某个值不在要求的范围内，则丢弃
			if(num <= 40) return num % 10 + 1;
		}
	}
}

class SolBase {
	public int rand7() {
		Random random = new Random();
		return random.nextInt(7) + 1;
	}

	public static void main(String[] args) {
		SolBase solBase = new SolBase();
		for (int i = 0; i < 100000; i++) {
			if (solBase.rand7() > 7 || solBase.rand7() < 1) {
				System.out.println("false");
			}
		}
	}
}


