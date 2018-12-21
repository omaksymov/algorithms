package leetcode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class ValidParentheses20Test {

    @Test
    public void isValid_ForValidRoundBrackets_ExpectedTrue() {
        String input = "()";
        ValidParentheses20 solution = new ValidParentheses20();
        assertThat(solution.isValid(input), is(true));
    }

    @Test
    public void isValid_ForValidDifferentBrackets_ExpectedTrue() {
        String input = "()[]{}";
        ValidParentheses20 solution = new ValidParentheses20();
        assertThat(solution.isValid(input), is(true));
    }

    @Test
    public void isValid_ForUnmatchingBrackets_ExpectedFalse() {
        String input = "(]";
        ValidParentheses20 solution = new ValidParentheses20();
        assertThat(solution.isValid(input), is(false));
    }

    @Test
    public void isValid_ForUnmatchingNestedBrackets_ExpectedFalse() {
        String input = "([)]";
        ValidParentheses20 solution = new ValidParentheses20();
        assertThat(solution.isValid(input), is(false));
    }

    @Test
    public void isValid_ForMatchingNestedBrackets_ExpectedTrue() {
        String input = "{[]}";
        ValidParentheses20 solution = new ValidParentheses20();
        assertThat(solution.isValid(input), is(true));
    }
}