package personal.dg.patterns.warmup;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram2(String s, String t) {
        char [] sArray = s.toCharArray();
        char [] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (! freqMap.containsKey(c)) {
                freqMap.put(c, 0);
            }
            freqMap.put(c, freqMap.get(c)+1);
        }

        for (char c : t.toCharArray()) {
            if (! freqMap.containsKey(c)) {
                freqMap.put(c, 0);
            }
            freqMap.put(c, freqMap.get(c)-1);
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (! entry.getValue().equals(0)) return false;
        }

        return true;

    }

}
