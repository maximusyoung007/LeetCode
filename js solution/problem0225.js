//参考了：https://leetcode-cn.com/problems/implement-stack-using-queues/solution/javascriptjie-fa-yi-ji-dui-javascriptbu-fen-apixin/
/**
 * Initialize your data structure here.
 */
var MyStack = function () {
    this.queue = [];
};

/**
 * Push element x onto stack. 
 * @param {number} x
 * @return {void}
 */
MyStack.prototype.push = function (x) {
    this.queue[this.queue.length] = x;
    return this.queue.length;
};

/**
 * Removes the element on top of the stack and returns that element.
 * @return {number}
 */
MyStack.prototype.pop = function () {
    if(this.empty())
        return undefined;
    let pop_ = this.queue[this.queue.length - 1];
    this.queue.length = this.queue.length - 1;
    return pop_;
};

/**
 * Get the top element.
 * @return {number}
 */
MyStack.prototype.top = function () {
    return this.queue[this.queue.length - 1];
};

/**
 * Returns whether the stack is empty.
 * @return {boolean}
 */
MyStack.prototype.empty = function () {
    if(this.queue.length == 0) {
        return true;
    }
    else 
        return false;
};

/**
 * Your MyStack object will be instantiated and called as such:
 **/
var obj = new MyStack();
obj.push(1);
obj.push(2);
obj.push(3);
obj.push(4);
var param_2 = obj.pop();
console.log(param_2);
var param_3 = obj.top();
console.log(param_3);
var param_4 = obj.empty();
console.log(param_4)