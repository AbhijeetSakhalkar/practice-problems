package personal.top150;

// https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150
public class LastWordLength {

    public static void main(String[] args) {
        String s = "  I am a    person      ";
        String[] sarr = s.split(" ");
        System.out.println(sarr);
    }

    public int lengthOfLastWord(String s) {
        String [] stringArray = s.split(" ");
        return stringArray[stringArray.length-1].length();
    }

}
