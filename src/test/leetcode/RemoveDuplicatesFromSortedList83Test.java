package leetcode;

import data_structure.list.ListNode;
import data_structure.list.SinglyLinkedList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RemoveDuplicatesFromSortedList83Test {
    @Parameterized.Parameters
    public static List<TestItem83> data(){
        List<TestItem83> data = new ArrayList<>();
        data.add(new TestItem83("[1]", "[1]"));
        data.add(new TestItem83("[1, 2]", "[1, 2]"));
        data.add(new TestItem83("[1, 1, 2]", "[1, 2]"));
        data.add(new TestItem83("[1, 1, 1, 2]", "[1, 2]"));
        data.add(new TestItem83("[1, 2, 2, 2, 2]", "[1, 2]"));
        data.add(new TestItem83("[1, 1, 2, 2, 3]", "[1, 2, 3]"));
        data.add(new TestItem83("[1, 1, 2, 3, 3, 3]", "[1, 2, 3]"));
        return data;
    }

    private static class TestItem83 {
        String origList;
        String expectedList;

        private TestItem83(String orig, String expected) {
            this.origList = orig;
            this.expectedList = expected;
        }
    }

    private TestItem83 testItem;

    public RemoveDuplicatesFromSortedList83Test(TestItem83 testItem) {
        this.testItem = testItem;
    }

    @Test
    public void deleteDuplicates() {
        RemoveDuplicatesFromSortedList83 solution  = new RemoveDuplicatesFromSortedList83();
        ListNode res = solution.deleteDuplicates(SinglyLinkedList.fromString(testItem.origList).getHead());
        assertEquals(testItem.expectedList, new SinglyLinkedList(res).toString());
    }
}