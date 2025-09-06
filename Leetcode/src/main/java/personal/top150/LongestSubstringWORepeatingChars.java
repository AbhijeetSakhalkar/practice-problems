package personal.top150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-interview-150
public class LongestSubstringWORepeatingChars {

    public static void main(String[] args) {
        LongestSubstringWORepeatingChars l = new LongestSubstringWORepeatingChars();
        int max = l.lengthOfLongestSubstring("dvdf");
        System.out.println(max);
    }


    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If duplicate, shrink window from left
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

}
