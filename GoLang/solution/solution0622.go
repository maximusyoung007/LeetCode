package solution

type MyCircularQueue struct {
	front    int
	end      int
	queue    []int
	capacity int
}

func Constructor0622(k int) MyCircularQueue {
	q := make([]int, k+1)
	return MyCircularQueue{0, 0, q, k + 1}
}

func (this *MyCircularQueue) EnQueue(value int) bool {
	if this.IsFull() {
		return false
	}
	this.queue[this.end] = value
	this.end = (this.end + 1) % this.capacity
	return true
}

func (this *MyCircularQueue) DeQueue() bool {
	if this.IsEmpty() {
		return false
	}
	this.front = (this.front + 1) % this.capacity
	return true
}

func (this *MyCircularQueue) Front() int {
	if this.IsEmpty() {
		return -1
	}
	return this.queue[this.front]
}

func (this *MyCircularQueue) Rear() int {
	if this.IsEmpty() {
		return -1
	}
	return this.queue[(this.end-1+this.capacity)%this.capacity]
}

func (this *MyCircularQueue) IsEmpty() bool {
	return this.front == this.end
}

func (this *MyCircularQueue) IsFull() bool {
	return (this.end+1)%this.capacity == this.front
}
