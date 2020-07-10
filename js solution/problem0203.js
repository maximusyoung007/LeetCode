/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 */
var removeElements = function(head, val) {
    var node = new ListNode(-1)
    node.next = head
    var pre = node,current = head
    while(current != null) {
        if(current.val == val) {
            pre.next = current.next
        }
        else
            pre = current
        current = current.next
    } 
    return node.next
}
function ListNode(val) {
    this.val = val
    this.next = null
}

//test
var node0 = new ListNode(1);
var node1 = new ListNode(2);
var node2 = new ListNode(6);
var node3 = new ListNode(3);
var node4 = new ListNode(4);
var node5 = new ListNode(5);
var node6 = new ListNode(6);
node0.next = node1
node1.next = node2
node2.next = node3
node3.next = node4
node4.next = node5
node5.next = node6
removeElements(node0,6)
var current = node0
while(current != null) {
    console.log(current)
    current = current.next
}