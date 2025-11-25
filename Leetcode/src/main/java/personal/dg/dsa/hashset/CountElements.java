package personal.dg.dsa.hashset;

import java.util.HashSet;

public class CountElements {
    public int countElements(int[] arr) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        for (int i : arr) {
            if (set.contains(i+1)) count++;
        }
        return count;
    }
}
