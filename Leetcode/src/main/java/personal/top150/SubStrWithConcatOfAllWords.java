package personal.top150;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

// https://leetcode.com/problems/substring-with-concatenation-of-all-words/?envType=study-plan-v2&envId=top-interview-150
public class SubStrWithConcatOfAllWords {

    public static void main(String[] args) {
        SubStrWithConcatOfAllWords s = new SubStrWithConcatOfAllWords();
        List<Integer> ans = s.findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
        System.out.println(ans);
    }


    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        if (words.length == 0 || s.isEmpty()) {
            return ans;
        }

        int wordSize = words[0].length();
        int wordCount = words.length;
        int N = s.length();

        Map<String,Integer> originalCount = new HashMap<>();
        for(int i = 0; i<words.length; i++){
            originalCount.put(words[i], originalCount.getOrDefault(words[i],0)+1);
        }

        for(int offset = 0; offset<wordSize; offset++){
            Map<String,Integer> currentCount = new HashMap<>();
            int start = offset;
            int count = 0;
            for(int end = offset; end + wordSize <= N; end += wordSize){
                String currWord = s.substring(end, end + wordSize);
                if(originalCount.containsKey(currWord)){
                    currentCount.put(currWord, currentCount.getOrDefault(currWord,0)+1);
                    count++;

                    while(currentCount.get(currWord)>originalCount.get(currWord)){
                        String startWord = s.substring(start,start+wordSize);
                        currentCount.put(startWord, currentCount.get(startWord)-1);
                        start+=wordSize;
                        count--;
                    }

                    if(count == wordCount){
                        ans.add(start);
                    }

                }
                else{
                    count = 0;
                    start = end + wordSize;
                    currentCount.clear();
                }
            }

        }
        return ans;
    }
}
