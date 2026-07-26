package personal.dg.patterns.warmup;

import java.util.Arrays;

public class ShortestDistance {

    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int shortestDistance = Integer.MAX_VALUE;

        for (int i = 0 ; i < words.length ; i ++) {
            if (words[i].equals(word1)) {
                p1 = i;
            }
            if (words[i].equals(word2)) {
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                shortestDistance = Integer.min(shortestDistance, Math.abs(p1-p2));
            }
        }

        return shortestDistance;
    }

    public static void main(String [] args) {
        ShortestDistance sd = new ShortestDistance();
        int shortestDistance = sd.shortestDistance(new String [] {"the","quick","brown","fox","jumps","over","the","lazy","dog"}, "fox" , "dog");
        System.out.println(shortestDistance);
    }

}
