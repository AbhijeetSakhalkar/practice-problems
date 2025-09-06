package personal.top150;


import java.util.Stack;

// https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=top-interview-150
public class ReverseWordsInString {

    public static void main(String[] args) {
        String s = "the sky is blue";
        ReverseWordsInString r = new ReverseWordsInString();
        String str = r.reverseWords(s);
        System.out.println(str);
    }

    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder(new String());
        int last = s.length()-1;
        int start;
        while(last >=0) {
            while(last>=0) {
                if((int)s.charAt(last) == 32) {
                    // pass, this is space
                    last--;
                } else {
                    break;
                }
            }
            start = last;
            while(start >=0 && (int)s.charAt(start) != 32 ) {
                start --;
            }
            str.append(s.substring(start+1,last+1));
            if(start != 0) {
                str.append(" ");
            }
            last = start;
        }
        return str.toString().trim();
    }

}
