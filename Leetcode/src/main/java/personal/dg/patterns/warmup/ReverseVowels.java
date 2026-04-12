package personal.dg.patterns.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ReverseVowels {


    public String reverseVowels(String s) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i' , 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char [] stringArray = s.toCharArray();
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            while (! vowels.contains(stringArray[left]) && left < right) {
                left ++;
            }
            while (! vowels.contains(stringArray[right]) && left < right) {
                right --;
            }
            char tmp = stringArray [left];
            stringArray[left] = stringArray[right];
            stringArray[right] = tmp;
            left ++;
            right --;
        }
        return new String(stringArray);
    }

    public String reverseVowelsUsingDS(String s) {

        List<Character> vowels = Arrays.asList('a', 'e', 'i' , 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        Stack <Character> vowelStack = new Stack<>();
        Queue <Character> nonVowelQueue = new LinkedList();
        List<Integer> vowelIndex = new ArrayList<>();
        int index = 0;
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                vowelStack.add(c);
                vowelIndex.add(index);
            } else {
                nonVowelQueue.add(c);
            }
            index ++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < s.length() ; i++) {
            if (vowelIndex.contains(i)) {
                sb.append(vowelStack.pop());
            } else {
                sb.append(nonVowelQueue.poll());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseVowels rv = new ReverseVowels();
        String test1 = rv.reverseVowels("hello");
        System.out.println(test1);
        String test2 = rv.reverseVowels("AEIOU");
        System.out.println(test2);
        String test3 = rv.reverseVowels("DesignGUrus");
        System.out.println(test3);
    }

}
