package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 * Input: "{[]}"
 * Output: true
 *
 * See ValidParentheses20Test for tests.
 */
public class ValidParentheses20 {
    private static final Map<Character, Character> PAIRS = new HashMap<Character, Character>(){{
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char curChar, prevChar;
        for (int i = 0; i < s.length(); ++i) {
            curChar = s.charAt(i);
            if (curChar == '(' || curChar == '{' || curChar == '[') {
                stack.push(curChar);
            } else { // consider that closing
                if (!stack.isEmpty()) {
                    prevChar = stack.pop();
                    if (PAIRS.get(prevChar) != curChar){
                        return false;
                    }
                } else {
                    return false; // more closing brackets than open ones
                }
            }
        }
        return stack.isEmpty(); // more opening brackets than closing ones
    }
}
