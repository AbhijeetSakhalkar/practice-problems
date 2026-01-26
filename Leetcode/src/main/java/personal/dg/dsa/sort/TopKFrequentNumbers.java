package personal.dg.dsa.sort;

import java.util.*;

public class TopKFrequentNumbers {
    public List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue <Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(frequencyMap.entrySet());
        for (int i = 0; i < k; ++i) {
            topNumbers.add(maxHeap.poll().getKey());
        }
        return topNumbers;
    }

    public static void main(String[] args) {
        TopKFrequentNumbers t = new TopKFrequentNumbers();
        List<Integer> ans = t.findTopKFrequentNumbers(new int[]{1, 3, 5, 12, 11, 12, 11}, 2);
        System.out.println(ans);
    }
}
