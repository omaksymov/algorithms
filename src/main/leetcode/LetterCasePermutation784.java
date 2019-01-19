package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation784 {
    public List<String> letterCasePermutation(String s) {
        int lettersCount = countLetters(s);
        int permCount = (int) Math.pow(2, lettersCount);
        List<String> res = new ArrayList<>(permCount);
        StringBuilder sb = new StringBuilder(s);
        if (sb.length() == 0) {
            res.add("");
        } else {
            permute(0, sb, res);
        }
        return res;
    }

    private void permute(int i, StringBuilder sb, List<String> res) {
        int n = sb.length();
        if (i >= n) return;
        char c = sb.charAt(i);
        if (!Character.isDigit(c)) {
            sb.setCharAt(i, Character.toLowerCase(c));
            if (i != n - 1) {
                permute(i + 1, sb, res);
            } else {
                res.add(sb.toString());
            }
            sb.setCharAt(i, Character.toUpperCase(c));
            if (i != n - 1) {
                permute(i + 1, sb, res);
            } else {
                res.add(sb.toString());
            }
        } else {
            if (i != n - 1) {
                permute(i + 1, sb, res);
            } else {
                res.add(sb.toString());
            }
        }
    }

    private int countLetters(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }
}
