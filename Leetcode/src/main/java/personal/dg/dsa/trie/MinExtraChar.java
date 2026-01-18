package personal.dg.dsa.trie;

import java.util.List;

public class MinExtraChar {
    public int minExtraChar(String s, List<String> dictionary) {
        for (String word : dictionary) {
            if (s.contains(word)) {
                s = s.replace(word, "");
            }
        }
        return s.length();
    }
}
