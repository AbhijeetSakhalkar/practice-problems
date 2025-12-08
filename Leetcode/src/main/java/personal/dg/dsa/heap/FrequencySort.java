package personal.dg.dsa.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public String frequencySort(String str) {

        Map<Character, Integer> freq = new HashMap<>();

        for(Character c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        maxHeap.addAll(freq.entrySet());

        StringBuilder result = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        FrequencySort f = new FrequencySort();
        String ans = f.frequencySort("trersesess");
        System.out.println(ans);
    }
}
