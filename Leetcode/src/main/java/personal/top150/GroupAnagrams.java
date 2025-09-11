package personal.top150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String key = getKey(str);
            if(map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String str : map.keySet()) {
            ans.add(map.get(str));
        }
        return ans;
    }

    public String getKey(String str) {
        char [] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

}
