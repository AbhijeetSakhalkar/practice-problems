package personal.dg.dsa.trie;

class TrieNode {
    TrieNode [] children = new TrieNode[26];
    boolean isEnd;

    public TrieNode() {
        isEnd = false;
        for (int i=0;i <26;i++) {
            children[i] = null;
        }
    }
}

public class Trie {
    private TrieNode root;

    public Trie () {
        this.root = new TrieNode();
    }

    public void insert (String word) {
        TrieNode node = root;
        for (int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0 ; i < word.length() ; i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEnd;
    }

    private boolean isEmpty(TrieNode root) {
        for (int i = 0 ; i < 26; i ++) {
            if (root.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    TrieNode deleteKey(TrieNode root, String key, int depth) {
        if (root == null) {
            return null;
        }
        if (depth == key.length()) {
            if (root.isEnd) {
                root.isEnd = false;
            }
            if (isEmpty(root)) {
                root = null;
            }
            return root;
        }

        int index = key.charAt(depth) - 'a';
        root.children[index] = deleteKey(root.children[index], key, depth + 1);

        if (isEmpty(root) && root.isEnd) {
            return null;
        }
        return root;
    }

    // Function to delete a word from the Trie
    void deleteWord(String word) {
        root = deleteKey(root, word, 0);
    }
}

