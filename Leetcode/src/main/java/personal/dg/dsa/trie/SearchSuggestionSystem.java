package personal.dg.dsa.trie;

import java.util.ArrayList;
import java.util.List;

class Triee {
    TrieNode root;
    public Triee() {
        root = new TrieNode();
    }
    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    void dfs (TrieNode node, List<String> list, StringBuilder word) {
        if (list.size() == 3) return;
        if (node.isEnd) {
            list.add(word.toString());
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (node.children[ch - 'a'] != null) {
                word.append(ch);
                dfs(node.children[ch - 'a'], list, word);
                word.deleteCharAt(word.length() - 1);
            }
        }
    }

    List<String> search(String prefix) {
        TrieNode node = root;
        List<String> list = new ArrayList<>();

        for (char ch : prefix.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                return list; // No words found with this prefix
            }
            node = node.children[ch - 'a'];
        }

        dfs(node, list, new StringBuilder(prefix));
        return list;
    }
}

public class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Triee trie = new Triee();
        for (String product : products) {
            trie.insert(product);
        }

        List<List<String>> result = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();

        for (char ch : searchWord.toCharArray()) {
            prefix.append(ch);
            result.add(trie.search(prefix.toString()));
        }

        return result;
    }


}
