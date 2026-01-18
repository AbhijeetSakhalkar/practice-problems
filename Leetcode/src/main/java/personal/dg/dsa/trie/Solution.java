package personal.dg.dsa.trie;


// DesignAndSearchWords
public class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    // Function to add a word into the trie structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isEnd = true;
    }

    // Function to search a word, considering '.' as a wildcard.
    public boolean search(String word) {
        return searchInNode(word, root);
    }

    private boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                // If it's a wildcard, recursively search for all possible characters.
                for (TrieNode child : node.children) {
                    if (child != null && searchInNode(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                // If the character doesn't exist, return false.
                if (node.children[ch - 'a'] == null) return false;
                node = node.children[ch - 'a'];  // Move to the next node.
            }
        }
        return node.isEnd;  // Return if we're at the end of a valid word.
    }
}
