package personal.dg.dsa.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortVowelsInString {
    // Sorts the vowels in a string while maintaining the position of consonants
    public String countingSortVowels(String s) {

        List<Character> allVowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        List<Integer> vowelIndex = new ArrayList<>();
        List<Character> vowelsInString = new ArrayList<>();
        for (int i = 0 ; i < s.length(); i++) {
            if (allVowels.contains(s.charAt(i))) {
                vowelIndex.add(i);
                vowelsInString.add(s.charAt(i));
            }
        }
        Collections.sort(vowelsInString);

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++) {
            if (vowelIndex.contains(i)) {
                stringBuilder.append(vowelsInString.remove(0));
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SortVowelsInString s = new SortVowelsInString();
        String ans = s.countingSortVowels("gamE");
        System.out.println(ans);
    }
}
