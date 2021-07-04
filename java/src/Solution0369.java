import dataStructure.ListNode;

import java.util.Stack;

/**
 * 用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。
 *
 * 你可以假设这个整数除了 0 本身，没有任何前导的 0。
 *
 * 这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0369 {
    public ListNode plusOne(ListNode head) {
        ListNode result = new ListNode(-1);
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int add = 1;
        while (!stack.empty()) {
            int t = stack.pop() + add;
            if (t < 10) {
                add = 0;
            } else {
                add = t / 10;
                t = t % 10;
            }
            ListNode tNode = new ListNode(t);
            tNode.next = result.next;
            result.next = tNode;
        }
        if (add == 1) {
            ListNode tNode = new ListNode(add);
            tNode.next = result.next;
            result.next = tNode;
        }
        return result.next;
    }
}
