import java.util.LinkedList;
import java.util.Queue;

public class LcOffer041 {
	public static void main(String[] args) {
		MovingAverage2 movingAverage2 = new MovingAverage2(3);
		System.out.println(movingAverage2.next(1));
		System.out.println(movingAverage2.next(10));
		System.out.println(movingAverage2.next(3));
		System.out.println(movingAverage2.next(5));
	}
}

class MovingAverage2 {
	Queue queue;
	int size;
	int capacity;
	double sum;
	/** Initialize your data structure here. */
	public MovingAverage2(int size) {
		queue = new LinkedList<>();
		this.capacity = size;
		this.size = 0;
		sum = 0;
	}

	public double next(int val) {
		if (this.size < capacity) {
			queue.add(val);
			this.size++;
		} else {
			int t = (int)queue.poll();
			queue.add(val);
			sum -= t;
		}
		sum += val;
		return sum / this.size;
	}

}
