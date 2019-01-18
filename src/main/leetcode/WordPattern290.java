package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 *
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 *
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 *
 * See <a href="https://leetcode.com/problems/word-pattern/">LeetCode problem 290</a> and test class for more examples
 * and details.
 */
public class WordPattern290 {
    public boolean wordPattern(String pattern, String str) {
        boolean matchesPattern = true;
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        String curWord;
        String patternWord;
        int strPos = 0;
        int strLength = str.length();
        for (char c : pattern.toCharArray()) {
            patternWord = charToWord.getOrDefault(c, null);
            curWord = readWord(strPos, str);
            if (curWord == null) {
                matchesPattern = false;
                break;
            }
            if (patternWord == null) {
                if (wordToChar.containsKey(curWord)) {
                    matchesPattern = wordToChar.get(curWord) == c;
                    if (!matchesPattern) break;
                }
                charToWord.put(c, curWord);
                wordToChar.put(curWord, c);
            } else {
                if (!patternWord.equals(curWord)) {
                    matchesPattern = false;
                    break;
                }
            }
            strPos = strPos + curWord.length() + 1;

        }
        return strPos >= strLength && matchesPattern;
    }

    private String readWord(int startPos, String str) {
        int n = str.length();
        if (startPos >= n) return null;
        char c;
        int i = startPos;
        StringBuilder word = new StringBuilder();
        while (i < n) {
            c = str.charAt(i++);
            if (c != ' ') {
                word.append(c);
            } else {
                break;
            }
        }
        return word.toString();
    }
}
