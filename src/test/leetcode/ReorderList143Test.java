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
public class ReorderList143Test {

    @Parameterized.Parameters
    public static List<TestItem143> data(){
        List<TestItem143> data = new ArrayList<>();
        data.add(new TestItem143("[1, 2, 3, 4]", "[1, 4, 2, 3]"));
        data.add(new TestItem143("[1, 2, 3, 4, 5]", "[1, 5, 2, 4, 3]"));
        return data;
    }

    private static class TestItem143 {
        String origList;
        String expectedList;

        private TestItem143(String orig, String expected) {
            this.origList = orig;
            this.expectedList = expected;
        }
    }

    private TestItem143 testItem;

    public ReorderList143Test(TestItem143 testItem) {
        this.testItem = testItem;
    }

    @Test
    public void solution1Test() {
        ReorderList143.Solution1 solution1 = new ReorderList143.Solution1();
        SinglyLinkedList list = SinglyLinkedList.fromString(testItem.origList);
        ListNode head = list.getHead();
        solution1.reorderList(head);
        assertEquals(testItem.expectedList, new SinglyLinkedList(head).toString());
    }

    @Test
    public void solution2Test() {
        ReorderList143.Solution2 solution2 = new ReorderList143.Solution2();
        SinglyLinkedList list = SinglyLinkedList.fromString(testItem.origList);
        ListNode head = list.getHead();
        solution2.reorderList(head);
        assertEquals(testItem.expectedList, new SinglyLinkedList(head).toString());
    }
}