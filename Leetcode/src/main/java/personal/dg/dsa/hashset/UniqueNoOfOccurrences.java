package personal.dg.dsa.hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNoOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for (Integer k : map.keySet()) {
            if (set.contains(map.get(k))) return false;
            set.add(map.get(k));
        }
        return true;
    }
}
