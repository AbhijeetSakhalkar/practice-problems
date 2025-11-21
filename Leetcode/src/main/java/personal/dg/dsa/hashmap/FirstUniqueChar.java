package personal.dg.dsa.hashmap;

public class FirstUniqueChar {


    public static void main(String[] args) {
        FirstUniqueChar f = new FirstUniqueChar();
        int ans = f.firstUniqChar("hello");
        System.out.println(ans);
    }

    public int firstUniqChar(String s) {
        int [] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c -'a'] ++;
        }
        for (int i = 0 ; i < s.length() ; i ++) {
            if (arr[(s.charAt(i))-'a'] == 1) return i;
        }
        return -1;
    }

}
