package personal.dg.dsa.heap;

import java.util.PriorityQueue;

public class MedianOfNumberStream {

    class Solution {

        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public Solution()
        {
            minHeap = new PriorityQueue<>((a,b) -> a-b);
            maxHeap = new PriorityQueue<>((a,b) -> b-a);
        }

        public void insertNum(int num) {

            if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            // either both the heaps will have equal number of elements or max-heap will have one
            // more element than the min-heap
            if (maxHeap.size() > minHeap.size()+1) {
                minHeap.add(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

        }

        public  double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (double) (minHeap.peek() + maxHeap.peek()) /2;
            }
            return maxHeap.peek();
        }
    }

}
