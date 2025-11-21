package personal.dg.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber {
    public int largestUniqueNumber(int[] A) {
        int ans = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            if (!map.containsKey(i)) {
                map.put(i , 0);
            }
            map.put(i, map.get(i)+1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                ans = Math.max(ans, key);
            }
        }
        return ans;
    }
}
