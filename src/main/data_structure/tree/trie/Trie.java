package data_structure.tree.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Trie {
    /**
     * {@link Trie} consists of such nodes.
     * NOTE: such node can be also implemented using fixed-length array in case characters being added
     * to the {@link Trie} are part of continuous range, such as a..z(26) or A..Z (26). Then it would be even faster
     * than map lookup.
     */
    public static class TrieNode {
        public Map<Character, TrieNode> next;
        public boolean isWord;

        public TrieNode() {
            next = new HashMap<>();
            isWord = false;
        }
        /**
         * Adds mapping to the character meaning that it will be part of some prefix during
         * further lookup in {@link Trie}.
         */
        public void add(char c) {
            next.put(c, new TrieNode());
        }

        /**
         *
         * @param c character to check for mapping
         * @return next {@link TrieNode} per character mapping or null if not found
         */
        public TrieNode get(char c) {
            return next.getOrDefault(c, null);
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void add(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        TrieNode curNode = root;
        for (char c : word.toCharArray()) {
            if (curNode.get(c) == null) {
                curNode.add(c);
            }
            curNode = curNode.get(c);
        }
        curNode.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curNode = root;
        for (char c : word.toCharArray()) {
            curNode = curNode.get(c);
            if (curNode == null) {
                return false;
            }
        }
        return curNode.isWord;
    }

    public boolean startsWith(String str) {
        TrieNode curNode = root;
        for (char c : str.toCharArray()) {
            curNode = curNode.get(c);
            if (curNode == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"cat", "map", "car", "bat","battery", "mapping", "caret", "catering"};
        System.out.println("Adding to trie:" + Arrays.toString(words));
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        String[] prefixes = {"cater", "maps", "butter", "car"};
        for (String prefix : prefixes) {
            String isPrefixStr = !trie.startsWith(prefix) ? "not" : "";
            System.out.println(String.format("%s is %s a prefix in a trie", prefix, isPrefixStr));
        }
        String[] searchWords = {"maps","tab","bat", "car","bar"};
        for (String word : searchWords) {
            String isPrefixStr = !trie.search(word) ? "not" : "";
            System.out.println(String.format("%s is %s in a trie", word, isPrefixStr));
        }
    }
}
