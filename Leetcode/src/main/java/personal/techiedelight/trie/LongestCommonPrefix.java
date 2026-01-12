package personal.techiedelight.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://www.techiedelight.com/?problem=LongestCommonPrefix
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] words = {"technique", "technician", "technology", "technical"};
        System.out.println("Longest Common Prefix: " + Solution.findLCP(words)); // Output: techn

        String[] words2 = {"techie delight", "tech", "techie", "technology", "technical"};
        System.out.println("Longest Common Prefix: " + Solution.findLCP(words2)); // Output: tech

        String[] words3 = {"apple", "apricot", "april"};
        System.out.println("Longest Common Prefix: " + Solution.findLCP(words3)); // Output: ap

        String[] words4 = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + Solution.findLCP(words4)); // Output: fl

        String[] words5 = {"dog", "racecar", "car"};
        System.out.println("Longest Common Prefix: " + Solution.findLCP(words5)); // Output: ""

        String[] words6 = {"a"};
        System.out.println("Longest Common Prefix: " + Solution.findLCP(words6)); // Output: a

        String[] words7 = {""};
        System.out.println("Longest Common Prefix: " + Solution.findLCP(words7)); // Output: ""

        String[] words8 = {"technique", "technician", "technology", "Tech"};
        System.out.println("Longest Common Prefix: " + Solution.findLCP(words8)); // Output: ""

    }

}

/*

Given a set of strings, find their longest common prefix (LCP).

Input: ["technique", "technician", "technology", "technical"]
Output: "techn"

Input: ["techie delight", "tech", "techie", "technology", "technical"]
Output: "tech"

*/

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;
    public TrieNode () {
        isEnd = false;
        children = new HashMap<>();
    }
}

class Trie {
    TrieNode root = new TrieNode();
    public void insert (String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isEnd = true;
    }
}

class Solution
{
    public static String findLCP(String[] words)
    {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        TrieNode node = trie.root;
        StringBuilder lcp = new StringBuilder();
        while (node!=null && !node.isEnd && getChildrenNo(node.children)==1) {
            Character c = getChar(node.children);
            lcp.append(c);
            node = node.children.get(c);
        }
        return lcp.toString();
    }

    private static int getChildrenNo(Map<Character, TrieNode> children) {
        return children.size();
    }

    private static Character getChar(Map<Character, TrieNode> children) {
        for (Character c : children.keySet()) {
            return c;
        }
        return null;
    }
}
