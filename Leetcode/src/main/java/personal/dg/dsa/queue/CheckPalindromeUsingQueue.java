package personal.dg.dsa.queue;

import java.util.Deque;
import java.util.LinkedList;

public class CheckPalindromeUsingQueue {

    public static boolean checkPalindrome(String s) {
        Deque<Character> dq = new LinkedList<>();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        for(char c : s.toCharArray()) {
            dq.addLast(c);
        }
        while (dq.size() > 1) {
            if (! dq.pollFirst().equals(dq.pollLast())) {
                return false;
            }
        }
        return true;
    }

}
