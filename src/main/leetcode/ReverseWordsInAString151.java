package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInAString151 {

    /**
     * Practically the slowest and the most error-prone to implement solution
     * Runtime: O(n) for trim + O(n) to count resulting string length + O(n) for reverse of whole string +
     * + O(k*log(k)) for sorting array of intermediate space positions + O(n) for reversing words.
     * Totally O(n + k*log(k)) runtime.
     * Space: O(2n + k) = O(n + k), where n is length of input, k is number of words
     */
    static class Solution1 {
        public String reverseWords(String s) {
            if (s == null) return "";
            StringBuilder sb = new StringBuilder(s.trim());
            if (sb.length() == 0) return "";
            List<Integer> wordEnds = reverse(sb);
            int start = 0;
            int end = sb.length();
            for (Integer wordEnd : wordEnds) {
                reverseWord(sb, start, wordEnd);
                start = wordEnd + 1;
            }
            reverseWord(sb, start, end);
            return sb.toString();
        }

        private List<Integer> reverse(StringBuilder sb) {
            List<Integer> wordEnds = new ArrayList<>();
            int newLength = countOutLength(sb);
            char[] cArr = new char[newLength];
            int lo = 0, ro = sb.length() - 1, lr = 0, rr = newLength - 1;
            char prevLeft = sb.charAt(lo), prevRight = sb.charAt(ro);
            while (lo <= ro) {
                if (sb.charAt(lo) != ' ' || prevLeft != ' ') {
                    cArr[rr] = sb.charAt(lo);
                    prevLeft = cArr[rr];
                    if (prevLeft == ' ') {
                        wordEnds.add(rr);
                    }
                    rr--;
                }
                if (sb.charAt(ro) != ' ' || prevRight != ' ') {
                    cArr[lr] = sb.charAt(ro);
                    prevRight = cArr[lr];
                    if (prevRight == ' ') {
                        wordEnds.add(lr);
                    }
                    lr++;
                }
                lo++;
                ro--;
            }
            sb.delete(0, sb.length()).append(new String(cArr));
            Collections.sort(wordEnds);
            return wordEnds;
        }

        private int countOutLength(StringBuilder sb) {
            if (sb.length() == 0) return 0;
            char prevChar = sb.charAt(0), curChar;
            int counter = 1;
            for (int i = 1; i < sb.length(); i++) {
                curChar = sb.charAt(i);
                if (curChar != ' ' || prevChar != ' ') {
                    counter++;
                    prevChar = curChar;
                }
            }
            return counter;
        }

        private void reverseWord(StringBuilder sb, int start, int end) {
            int l = start;
            int r = end - 1;
            while (l < r) {
                swap(sb, l, r);
                l++;
                r--;
            }
        }

        private void swap(StringBuilder sb, int a, int b) {
            char tmp = sb.charAt(a);
            sb.setCharAt(a, sb.charAt(b));
            sb.setCharAt(b, tmp);
        }
    }

    /**
     * Optimized solution, which uses additional space only for representing String as array of chars -
     * it avoids redundant Java String processing memory allocations.
     * Runtime: O(n) to remove redundant spaces + O(n) to reverse whole sentence without redundant spaces +
     * + O(n) to reverse back words into readable state = O(n), where n is input string length
     * Space: O(n) to represent input as char[], where n is input string length
     */
    static class Solution2 {
        public String reverseWords(String s) {
            if (s == null) return "";
            char[] cstr = s.toCharArray();

            int n = removeRedundantSpaces(cstr);
            int j = 0;
            while (j < n && cstr[j] == ' ') j++;
            int start = j;
            reverse(cstr, start, n - 1);
            for (int i = start; i < n; i++) {
                if (cstr[i] == ' ') {
                    reverse(cstr, start, i - 1);
                    start = i + 1;
                }
            }
            reverse(cstr, start, n - 1);
            return new String(cstr, 0, n);
        }

        // returns length of string without redundant spaces
        private int removeRedundantSpaces(char[] cstr) {
            int i = 0;
            int j = 0;
            int n = cstr.length;
            while (j < n) {
                while (j < n && cstr[j] == ' ') j++; // skip leading spaces before word
                while (j < n && cstr[j] != ' ') cstr[i++] = cstr[j++]; // record the word (non-spaces)
                while (j < n && cstr[j] == ' ') j++; // skip trailing spaces after word
                if (j < n) cstr[i++] = ' '; // single space after word in result
            }
            return i;
        }

        // start inclusively, end inclusively
        private void reverse(char[] cstr, int start, int end) {
            if (end <= start) return;
            int l = start;
            int r = end;
            while (l < r) {
                swap(cstr, l, r);
                l++;
                r--;
            }
        }

        private void swap(char[] cstr, int i, int j) {
            char tmp = cstr[i];
            cstr[i] = cstr[j];
            cstr[j] = tmp;
        }
    }

    /**
     * Cheaty: using built-in split function to avoid issues with intermediate spaces
     * Practically - the fastest one.
     * Runtime: O(n): 2 passes = n for split + n for combining words in reverse order
     * Space: O(n), where n is length of initial input
     */
    static class Solution3 {
        public String reverseWords(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            String[] arr = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = arr.length - 1; i >= 0; --i) {
                if (!arr[i].equals("")) {
                    sb.append(arr[i]).append(" ");
                }
            }
            return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
        }
    }
}
