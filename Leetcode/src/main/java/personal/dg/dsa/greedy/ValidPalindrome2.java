package personal.dg.dsa.greedy;

public class ValidPalindrome2 {
    // Method to check if it's possible to form a palindrome
    public static boolean isPalindromePossible(String str) {
        int l = 0;
        int r = str.length()-1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return isPalindrome(str, l+1, r) || isPalindrome(str, l, r-1);
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean isPalindrome(String str , int l, int r) {
        while(l<r) {
            if (str.charAt(l++)!= str.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
