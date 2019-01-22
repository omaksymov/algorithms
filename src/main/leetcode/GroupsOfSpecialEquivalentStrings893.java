package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * You are given an array A of strings.
 * <p>
 * Two strings S and T are special-equivalent if after any number of moves, S == T.
 * <p>
 * A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].
 * <p>
 * Now, a group of special-equivalent strings from A is a non-empty subset S of A such that any string not in S is not special-equivalent with any string in S.
 * <p>
 * Return the number of groups of special-equivalent strings from A.
 * <p>
 * Example :
 * Input: ["abc","acb","bac","bca","cab","cba"]
 * Output: 3
 * Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
 * <p>
 * Note:
 * 1 <= A.length <= 1000
 * 1 <= A[i].length <= 20
 * All A[i] have the same length.
 * All A[i] consist of only lowercase letters.
 * <p>
 * See LeetCode <a href="https://leetcode.com/problems/groups-of-special-equivalent-strings/">Groups of Special-Equivalent Strings</a> problem (893)
 * and more examples in test class.
 */
public class GroupsOfSpecialEquivalentStrings893 {

    /**
     * According to the problem description, two strings S and T are specially equal when permutation of letters on
     * respective odd or even positions will result in standard string equality. We need a mapping function with property
     * f(S)=f(T) < - > S is specially equal to T. By analogy with counting letters in strings to check if one is
     * permutation of another, we'll count letters at odd and even positions respectively. As only lower case english
     * letters will be in input - it's enough to have 26*2 length array to count that.
     * Then map array to single string with Arrays.toString() and it will be the value of the function f().
     */
    public int numSpecialEquivGroups(String[] a) {
        Set<String> seen = new HashSet<>();
        for (String s : a) {
            int[] count = new int[52];
            getEquivalenceMapping(s, count);
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }

    // counts number of alphabet letters at odd and even positions separately
    private void getEquivalenceMapping(String s, int[] count) {
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            count[s.charAt(i) - 'a' + 26 * (i % 2)]++;
        }
    }
}
