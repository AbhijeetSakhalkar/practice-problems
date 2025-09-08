package personal.top150;

import java.util.Arrays;

public class RansomNote {

    public static void main(String[] args) {
        System.out.println((int) 'a');

        RansomNote r = new RansomNote();
        boolean b = r.canConstruct("aba", "aabb");
        System.out.println(b);
    }

    public boolean canConstruct(String ransomNote, String magazine) {

        int [] map = new int[26];
        for(char c : magazine.toCharArray()) {
            map[getIndex(c)] ++;
        }

        for(char c: ransomNote.toCharArray()) {
            map[getIndex(c)]--;
            if(map[getIndex(c)] < 0) return false;
        }
        return true;
    }

    private int getIndex(char c) {
        return (int) c - 97;
    }

}
