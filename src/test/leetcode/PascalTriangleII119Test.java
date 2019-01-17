package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class PascalTriangleII119Test {
    @Parameterized.Parameters
    public static List<TestItem119> data() {
        List<TestItem119> data = new ArrayList<>();
        data.add(new TestItem119(0, Collections.singletonList(1)));
        data.add(new TestItem119(1, Arrays.asList(1, 1)));
        data.add(new TestItem119(2, Arrays.asList(1, 2, 1)));
        data.add(new TestItem119(3, Arrays.asList(1, 3, 3, 1)));
        data.add(new TestItem119(4, Arrays.asList(1, 4, 6, 4, 1)));
        data.add(new TestItem119(10, Arrays.asList(1,10,45,120,210,252,210,120,45,10,1)));
        data.add(new TestItem119(13, Arrays.asList(1,13,78,286,715,1287,1716,1716,1287,715,286,78,13,1)));
        data.add(new TestItem119(20, Arrays.asList(1,20,190,1140,4845,15504,38760,77520,125970,167960,184756,167960,125970,77520,38760,15504,4845,1140,190,20,1)));
        data.add(new TestItem119(30, Arrays.asList(1,30,435,4060,27405,142506,593775,2035800,5852925,14307150,30045015,54627300,86493225,119759850,145422675,155117520,145422675,119759850,86493225,54627300,30045015,14307150,5852925,2035800,593775,142506,27405,4060,435,30,1)));
        data.add(new TestItem119(33, Arrays.asList(1,33,528,5456,40920,237336,1107568,4272048,13884156,38567100,92561040,193536720,354817320,573166440,818809200,1037158320,1166803110,1166803110,1037158320,818809200,573166440,354817320,193536720,92561040,38567100,13884156,4272048,1107568,237336,40920,5456,528,33,1)));
        return data;
    }
    private TestItem119 testItem;

    public PascalTriangleII119Test(TestItem119 testItem) {
        this.testItem = testItem;
    }

    @Test
    public void getRow_Solution1() {
        PascalTriangleII119.Solution1 solution = new PascalTriangleII119.Solution1();
        List<Integer> res = solution.getRow(testItem.rowIndex);
        assertArrayEquals(testItem.expectedRow.toArray(), res.toArray());
    }

    @Test
    public void getRow_Solution2() {
        PascalTriangleII119.Solution2 solution = new PascalTriangleII119.Solution2();
        List<Integer> res = solution.getRow(testItem.rowIndex);
        assertArrayEquals(testItem.expectedRow.toArray(), res.toArray());
    }

    private static class TestItem119 {
        // starting from 0
        int rowIndex;
        List<Integer> expectedRow;

        private TestItem119(int rowIndex, List<Integer> expectedRow) {
            this.rowIndex = rowIndex;
            this.expectedRow = expectedRow;
        }
    }
}