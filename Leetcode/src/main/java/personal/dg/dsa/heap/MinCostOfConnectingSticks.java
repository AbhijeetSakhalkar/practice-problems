package personal.dg.dsa.heap;

import java.util.PriorityQueue;

public class MinCostOfConnectingSticks {

    public static void main(String[] args) {
        MinCostOfConnectingSticks m = new MinCostOfConnectingSticks();
        m.connectSticks(new int[]{5,5,5,5});
    }

    public int connectSticks(int[] sticks) {
        int cost = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stick : sticks) {
            minHeap.add(stick);
        }
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int third = first + second;
            cost += third;
            minHeap.add(third);
        }
        return cost;
    }
}
