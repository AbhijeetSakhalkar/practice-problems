package personal.dg.patterns.warmup;

public class Pangram {
    public boolean checkIfPangram(String sentence) {
        int [] charArray = new int[26];
        sentence = sentence.toLowerCase();
        for (char c : sentence.toCharArray()) {
            if (! Character.isLetter(c)) {
                continue;
            }
            charArray[c - 'a'] ++;
        }
        for (int i : charArray) {
            if (i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Pangram p = new Pangram();
        boolean test1 = p.checkIfPangram("Test Sentence");
        System.out.println(test1);

        boolean test2 = p.checkIfPangram("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        System.out.println(test2);

        boolean test3 = p.checkIfPangram("1234567890");
        System.out.println(test3);

    }
}
