package mockinterview;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FixParkingTest {
    @Parameterized.Parameters
    public static List<FixParkingTestItem> data() {
        List<FixParkingTestItem> data = new ArrayList<>();
        data.add(new FixParkingTestItem(new Integer[]{1, 3, null, 5, 8},
                                        new Integer[]{8, null, 5, 3, 1}));
        data.add(new FixParkingTestItem(new Integer[]{1, null},
                                        new Integer[]{null, 1}));
        data.add(new FixParkingTestItem(new Integer[]{null, 1},
                                        new Integer[]{null, 1}));
        data.add(new FixParkingTestItem(new Integer[]{null, 1, 13, 2, 76},
                                        new Integer[]{null, 1, 76, 2, 13}));
        return data;
    }

    private static class FixParkingTestItem {
        Integer[] expected;
        Integer[] actual;

        private FixParkingTestItem(Integer[] expected, Integer[] actual) {
            this.expected = expected;
            this.actual = actual;
        }
    }

    private FixParkingTestItem testItem;

    public FixParkingTest(FixParkingTestItem testItem) {
        this.testItem = testItem;
    }

    @Test
    public void fixParking_Solution1() {
        FixParking.Solution1 solution = new FixParking.Solution1();
        solution.fixParking(testItem.expected, testItem.actual);
        assertArrayEquals(testItem.expected, testItem.actual);
    }

    @Test
    public void fixParking_Solution2() {
        FixParking.Solution2 solution = new FixParking.Solution2();
        solution.fixParking(testItem.expected, testItem.actual);
        assertArrayEquals(testItem.expected, testItem.actual);
    }
}