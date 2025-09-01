package personal.top150;


// https://leetcode.com/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
public class Palindrome {
    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        boolean b = p.isPalindrome2("0P");
        System.out.println(b);
    }

    public boolean isPalindrome2(String s) {
        s = s.toLowerCase();
        int l = 0;
        int r = s.length()-1;
        while(l < r) {
            while(! Character.isLetterOrDigit(s.charAt(l)) && l<r) {
                l++;
            }
            while(! Character.isLetterOrDigit(s.charAt(r)) && l<r) {
                r--;
            }
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            } else {
                l ++;
                r --;
            }
        }
        return true;
    }
}
