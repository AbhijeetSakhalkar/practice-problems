package personal.dg.dsa.hashset;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstrWithoutRepeatingChars {

    public static void main(String[] args) {
        LongestSubstrWithoutRepeatingChars l = new LongestSubstrWithoutRepeatingChars();
        int ans = l.lengthOfLongestSubstring("abcdaef");
        System.out.println(ans);
    }

    public int lengthOfLongestSubstring(String str) {
        int maxLength = 0;
        int start = 0; int end=0;
        Set<Character> set = new HashSet<>();
        while(end < str.length()) {
            if (!set.contains(str.charAt(end))) {
                set.add(str.charAt(end));
                maxLength = Math.max(maxLength, (end-start+1));
                end ++;
            } else {
                set.remove(str.charAt(start));
                start++;
            }
        }
        return maxLength;
    }
}
