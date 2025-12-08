package personal.dg.dsa.heap;

import java.util.PriorityQueue;

public class RemainingGifts {
    public int remainingGifts(int[] gifts, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        // Populate max heap
        // By default its a min heap so add - values
        for(int i : gifts) {
            maxHeap.add(-i);
        }

        for(int i = 0 ; i < k ; i++) {
            int max = -maxHeap.poll();
            maxHeap.add(-(int)Math.sqrt(max));
        }
        int result = 0;
        while(! maxHeap.isEmpty()) {
            result += -maxHeap.poll();
        }

        return result;
    }
}
