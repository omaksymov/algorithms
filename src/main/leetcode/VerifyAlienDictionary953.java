package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet,
 * return true if and only if the given words are sorted lexicographicaly in this alien language.
 *
 * See LeetCode <a href="https://leetcode.com/problems/verifying-an-alien-dictionary/>Verify Alien Dictionary</a>
 * problem (953) and examples in test class.
 */
public class VerifyAlienDictionary953 {
    /**
     * Solution using Trie data structure: add all words into trie, while checking if adding next character does not
     * violate lexicographic order for existing characters (if any) in the same level (position of letter in a word).
     * This is slower than solution 2, because adds whole word even when we lexicographic order is guaranteed by
     * the first letters.
     */
    static class Solution1 {
        private static class TrieNode {
            private TrieNode[] nodes;
            private int lastNonEmpty;

            private TrieNode() {
                nodes = new TrieNode[26];
                lastNonEmpty = -1;
            }

            /**
             * @return true when letter is added in lexicographical order, false otherwise
             */
            public boolean add(int i) {
                if (nodes[i] == null) {
                    nodes[i] = new TrieNode();
                }
                if (i >= lastNonEmpty) {
                    lastNonEmpty = i;
                    return true;
                }
                return false;
            }

            public TrieNode get(int i) {
                return nodes[i];
            }
        }

        private TrieNode root;
        private Map<Character, Integer> alphabet;

        public boolean isAlienSorted(String[] words, String order) {
            // idea is to use Trie, where TrieNodes of consequent elements will be defined by "order" instead of typical English Alphabet
            alphabet = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                alphabet.put(order.charAt(i), i);
            }
            root = new TrieNode();
            for (String word : words) {
                if (!addWord(word)) {
                    return false;
                }
            }
            return true;
        }

        private boolean addWord(String word) {
            TrieNode curNode = root;
            for (char c : word.toCharArray()) {
                if (!curNode.add(alphabet.get(c))) {
                    return false;
                }
                curNode = curNode.get(alphabet.get(c));
            }
            return curNode.lastNonEmpty == -1;
        }
    }

    /**
     * Uses idea of transitivity if compare a<=b, b<=c => a<=c;
     * So we have to compare pairs of adjacent words for lexicographic order, starting from the first one.
     * If there is any mismatch - fail fast and return false;
     */
    static class Solution2 {
        public boolean isAlienSorted(String[] words, String order) {
            // maps english characters' position to their positions in alien dictionary
            int[] alphabet = new int[26];
            for (int i = 0; i < 26; i++) {
                alphabet[order.charAt(i) - 'a'] = i;
            }
            String curWord, nextWord;
            int rightLimit = words.length - 1;
            for (int i = 0; i < rightLimit; i++) {
                curWord = words[i];
                nextWord = words[i + 1];
                int charLimit = Math.min(curWord.length(), nextWord.length());
                int k = 0;
                for (; k < charLimit; k++) {
                    while (k < charLimit && curWord.charAt(k) == nextWord.charAt(k)) k++;
                    if (k < charLimit){
                        int alienNextChar = alphabet[nextWord.charAt(k) - 'a'];
                        int alienCurChar = alphabet[curWord.charAt(k) - 'a'];
                        if (alienNextChar < alienCurChar) {
                            return false;
                        } else if (alienNextChar > alienCurChar) {
                            break;
                        } // else alienNextChar == alienCurChar -> continue
                    } else {
                        break;
                    }
                }
                if (k == charLimit && curWord.length() > nextWord.length()) {
                    return false;
                }
            }
            return true;
        }
    }

}
