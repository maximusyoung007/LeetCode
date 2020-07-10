/**
 * @param {ListNode} head
 * @return {ListNode}
 */
function ListNode(val) {
    this.val = val;
    this.next = null;
}
var reverseList = function (head) {
    let pre = null;
    let curr = head;
    while(curr) {
        let temp = curr.next;
        curr.next = pre;
        pre = curr;
        curr = temp;
    }
    return pre;
};

let head = new ListNode(1);
let node2 = new ListNode(2);
let node3 = new ListNode(3);
let node4 = new ListNode(4);
let node5 = new ListNode(5);
head.next = node2;
node2.next = node3;
node3.next = node4;
node4.next = node5;
let head2 = reverseList(head);
while(head2) {
    console.log(head2.val);
    head2 = head2.next;
}