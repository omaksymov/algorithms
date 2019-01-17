package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ExcelSheetColumnTitle168Test {
    @Parameterized.Parameters
    public static List<TestItem168> data() {
        List<TestItem168> data = new ArrayList<>();
        data.add(new TestItem168(1, "A"));
        data.add(new TestItem168(2, "B"));
        data.add(new TestItem168(25, "Y"));
        data.add(new TestItem168(26, "Z"));
        data.add(new TestItem168(27, "AA"));
        data.add(new TestItem168(28, "AB"));
        data.add(new TestItem168(52, "AZ"));
        data.add(new TestItem168(53, "BA"));
        data.add(new TestItem168(690, "ZN"));
        data.add(new TestItem168(701, "ZY"));
        data.add(new TestItem168(703, "AAA"));
        data.add(new TestItem168(725, "AAW"));
        return data;
    }

    TestItem168 testItem;

    public ExcelSheetColumnTitle168Test(TestItem168 testItem) {
        this.testItem = testItem;
    }

    private static class TestItem168 {
        int n;
        String expectedColumnName;

        private TestItem168(int n, String expectedColumnName) {
            this.n = n;
            this.expectedColumnName = expectedColumnName;
        }
    }

    @Test
    public void convertToTitle() {
        ExcelSheetColumnTitle168 solution = new ExcelSheetColumnTitle168();
        String actualColumnName = solution.convertToTitle(testItem.n);
        assertEquals(testItem.expectedColumnName, actualColumnName);
    }
}