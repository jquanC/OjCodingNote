package SwordOf.sort;

import java.util.PriorityQueue;
import java.util.Queue;

/**保持平衡，规定：偶数个元素，插入minHeap(大的一半),奇数个元素，插入maxHeap（小的一半）
 * minHeap,保存较大的一半，小顶堆保存较小的一半*/
public class MedianFinder {
    Queue<Integer> minHeap,maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>((x,y)->(y-x));
    }

    /**先find pos */
    public void addNum(int num) {
        int size = minHeap.size()+maxHeap.size();
        if(size%2==0){
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }else{
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        int size = minHeap.size()+maxHeap.size();
        if(size%2==0){
            return (double)(minHeap.peek()+maxHeap.peek())/2;//peek,不是poll
        }else return (double)minHeap.peek();
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
