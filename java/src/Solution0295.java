import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution0295 {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}

class MedianFinder {
    int count;
    double mid;
    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;
    /** initialize your data structure here. */
    public MedianFinder() {
        mid = 0;
        count = 0;
        maxQueue = new PriorityQueue<>();
        minQueue = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }

    public void addNum(int num) {
        if (count == 0) {
            minQueue.add(num);
        }
        else {
            if (num <= minQueue.peek()) {
                minQueue.add(num);
                if (maxQueue.size() + 1 < minQueue.size()) {
                    int t = minQueue.poll();
                    maxQueue.add(t);
                }
            } else {
                maxQueue.add(num);
                if (maxQueue.size() > minQueue.size()) {
                    int t = maxQueue.poll();
                    minQueue.add(t);
                }
            }
        }
        count++;
    }


    public double findMedian() {
        if (count == 0) {
            return 0;
        } else if (count == 1) {
            return minQueue.peek();
        } else {
            if (count % 2 != 0) {
                return minQueue.peek();
            } else {
                return ((double) minQueue.peek() + (double) maxQueue.peek()) / 2;
            }
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
