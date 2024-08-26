
public class Solution0287 {

	/**
	 * [1,3,4,2,2]
	 * n->f(n)映射关系
	 * 0, nums[0]=1, nums[1]=3,nums[3]=2,nums[2]=4,nums[4]=2,nums[2]=4
	 * 即0，1，3，2，4，2，4... 会进入环路
	 * 使用快慢指针，慢指针slow一次走一步，快指针fast一次走两步
	 * 设起点到环的入口长度为m，环的周长为c，
	 * slow走了n步，fast走了2n步，两者相遇时，slow在环中走了n-m步，fast在环中走了2n-m步，slow=fast, fast比slow多走了整数圈，
	 * 即[2n-m-(n-m)]%c=0, 即n%c=0
	 * slow在环中走了n-m步，再在环中走m步，就走n步了，n%c=0,所以刚好是回到环的起点
	 * 因为不知道m的长度，所以用finder指针和slow一起走，两者相遇的时候，就是走了m步，实际编码时，可以用fast代替finder
	 */
	public int findDuplicate(int[] nums) {
		int slow = 0, fast = 0;

		//因为初始的时候，slow=fast,所以要用do...while
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		//用fast代替finder
		fast = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}

		return slow;
	}
}
