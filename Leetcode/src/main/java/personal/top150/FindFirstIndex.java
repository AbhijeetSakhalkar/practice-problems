package personal.top150;

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
public class FindFirstIndex {

    public static void main(String[] args) {
        FindFirstIndex f = new FindFirstIndex();
        int ans = f.strStr("hello", "ll");
        System.out.println(ans);
    }

    public int strStr(String haystack, String needle) {
        int ans = -1;
        if(! needle.isEmpty()) {
            char firstChar = needle.charAt(0);
            for(int i=0; i < haystack.length(); i++) {
                if(haystack.charAt(i) == firstChar) {
                    if(i+needle.length() <= haystack.length()) {
                        String sub = haystack.substring(i, i+needle.length());
                        if(sub.equals(needle)){
                            return i;
                        }
                    }
                }
            }
        }
        return ans;
    }

}
