package personal.dg.dsa.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// class TrieNode {
//     TrieNode[] children = new TrieNode[26]; // Array to hold child nodes for each letter
//     boolean isEnd = false; // Flag to mark the end of a word
// }

class Trie2 {
    TrieNode root = new TrieNode();

    public void insert (String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c-'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }
}

public class IndexPairs {
    public List<List<Integer>> indexPairs(String text, List<String> words) {
        List<List<Integer>> result = new ArrayList<>();
        Trie2 trie = new Trie2();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0 ; i < text.length(); i++) {
            TrieNode node = trie.root;
            for (int j = i ; j < text.length() ; j++) {
                char c = text.charAt(j);
                if (node.children[c - 'a'] == null) {
                    break;
                }
                node = node.children[c-'a'];
                if (node.isEnd) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result; // Return a list of lists containing index pairs
    }

    // Main method for testing
    public static void main(String[] args) {
        IndexPairs indexPairs = new IndexPairs();
        // Test examples
        String text1 = "bluebirdskyscraper";
        List<String> words1 = Arrays.asList("blue", "bird", "sky");
        System.out.println(indexPairs.indexPairs(text1, words1));

//        String text2 = "programmingisfun";
//        List<String> words2 = Arrays.asList("pro", "is", "fun", "gram");
//        System.out.println(solution.indexPairs(text2, words2));
//
//        String text3 = "interstellar";
//        List<String> words3 = Arrays.asList("stellar", "star", "inter");
//        System.out.println(solution.indexPairs(text3, words3));
    }
}
