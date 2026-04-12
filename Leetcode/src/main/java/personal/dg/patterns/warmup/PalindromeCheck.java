package personal.dg.patterns.warmup;

public class PalindromeCheck {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                left ++;
            }
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                right --;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeCheck pc =new PalindromeCheck();
        System.out.println(pc.isPalindrome("A man, a plan, a canal, Panama!"));
        System.out.println(pc.isPalindrome("Was it a car or a cat I saw?"));
    }
}
