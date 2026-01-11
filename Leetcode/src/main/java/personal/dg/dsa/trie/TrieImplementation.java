package personal.dg.dsa.trie;

// class TrieNode {
//     TrieNode[] children = new TrieNode[26]; // Represents each letter of the alphabet.
//     boolean isEnd; // Flag to represent if the node is the end of a word.

//     public TrieNode() {}
// }

public class TrieImplementation {
    private TrieNode root;

    public TrieImplementation() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0 ; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0 ; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEnd;
    }

    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0 ; i < prefix.length() ; i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}

