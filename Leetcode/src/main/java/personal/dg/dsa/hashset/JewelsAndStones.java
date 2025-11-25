package personal.dg.dsa.hashset;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (Character c : jewels.toCharArray()) {
            set.add(c);
        }
        for (Character c : stones.toCharArray()) {
            if (set.contains(c)) count++;
        }
        return count;
    }
}
