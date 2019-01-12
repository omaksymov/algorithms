package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SortArrayByParity905Test {
    @Parameterized.Parameters
    public static List<TestItem905> data() {
        List<TestItem905> data = new ArrayList<>();
        data.add(new TestItem905(new int[]{3, 1, 2, 4}));
        data.add(new TestItem905(new int[]{1}));
        data.add(new TestItem905(new int[]{2}));
        data.add(new TestItem905(new int[]{1, 3}));
        data.add(new TestItem905(new int[]{4, 2}));
        data.add(new TestItem905(new int[]{1, 4}));
        data.add(new TestItem905(new int[]{2, 1}));
        data.add(new TestItem905(new int[]{2, 4, 1, 3}));
        data.add(new TestItem905(new int[]{2, 4, 1, 3, 5}));
        data.add(new TestItem905(new int[]{2, 4, 6, 3, 5}));
        data.add(new TestItem905(new int[]{1, 3, 2, 4}));
        data.add(new TestItem905(new int[]{1, 3, 2, 4, 6}));
        data.add(new TestItem905(new int[]{1, 3, 5, 2, 4}));
        data.add(new TestItem905(new int[]{1, 2, 5, 3, 4}));
        data.add(new TestItem905(new int[]{2, 1, 4, 5, 6}));
        return data;
    }

    private TestItem905 testItem;

    public SortArrayByParity905Test(TestItem905 testItem) {
        this.testItem = testItem;
    }

    @Test
    public void sortArrayByParity() {
        SortArrayByParity905 solution = new SortArrayByParity905();
        int[] actualRes = solution.sortArrayByParity(testItem.input);
        Map<Integer, Integer> countsMap = count(actualRes);
        assertTrue(checkParity(actualRes, countsMap));
    }

    private boolean checkParity(int[] a, Map<Integer, Integer> count) {
        int n = a.length;
        int i = 0;
        while (i < n && a[i] % 2 == 0) {
            if (count.containsKey(a[i])) {
                count.put(a[i], count.get(a[i]) - 1);
            } else {
                return false;
            }
            i++;
        }
        while (i < n && a[i] % 2 != 0) {
            if (count.containsKey(a[i])) {
                count.put(a[i], count.get(a[i]) - 1);
            } else {
                return false;
            }
            i++;
        }
        if (i != n) return false;
        for (Integer countItem : count.values()) {
            if (countItem != 0) {
                return false;
            }
        }
        return true;
    }

    private Map<Integer, Integer> count(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map;
    }

    private static class TestItem905 {
        int[] input;

        private TestItem905(int[] input) {
            this.input = input;
        }
    }
}