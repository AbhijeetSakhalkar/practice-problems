package personal.daily;

// https://leetcode.com/problems/maximum-number-of-words-you-can-type/description/?envType=daily-question&envId=2025-09-15
public class TypedWords {

    public static void main(String[] args) {
        TypedWords t = new TypedWords();
        int ans = t.canBeTypedWords("leet code", "lt");
        System.out.println(ans);
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        String [] allWords = text.split(" ");
        int ans = 0;
        for(String s : allWords) {
            if(! isPresent(s, brokenLetters)) ans ++;
        }
        return ans;
    }

    private boolean isPresent(String word, String brokenLetters) {
        for (char c : brokenLetters.toCharArray()) {
            if (word.indexOf(c) != -1) return true;
        }
        return false;
    }

}
