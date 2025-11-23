package personal.dg.dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class MaxNoOfBalloons {
    public static void main(String[] args) {
        MaxNoOfBalloons m = new MaxNoOfBalloons();
        int ans = m.maxNumberOfBalloons("balloonballoon");
        System.out.println(ans);
    }
    public int maxNumberOfBalloons(String text) {
        String s = "balloon";
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('b',0);
        map.put('a',0);
        map.put('l',0);
        map.put('o',0);
        map.put('n',0);
        for(Character c : text.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c)+1);
        }
        boolean notDone = true;
        while(notDone) {
         for(Character c : s.toCharArray()) {
             if (map.get(c) < 1) {
                 notDone = false;
                 break;
             }
             map.put(c, map.get(c)-1);
         }
         if (notDone) {
             ans ++;
         }

        }
        return ans;
    }
}
