package personal.dg.dsa.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FrequecySort {
    // Method to sort the array based on frequency
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        TreeMap<Integer, List<Integer>> tree = new TreeMap<>();
        for (int key : freq.keySet()) {
            int value = freq.get(key);
            if (tree.containsKey(value)) {
                tree.get(value).add(key);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(key);
                tree.put(value, list);
            }
        }
        int index = 0;
        for (int key : tree.keySet()) {
            List<Integer> values = tree.get(key);
            values.sort(Comparator.reverseOrder());
            for (int value : values) {
                for(int j = 0 ; j < key ; j++) {
                    nums[index++] = value;
                }
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        FrequecySort f = new FrequecySort();
        int [] ans = f.frequencySort(new int[]{4, 4, 4, 5, 5, 5, 6, 6, 7, 7, 8});
        System.out.println(Arrays.toString(ans));
    }
}
