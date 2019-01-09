package leetcode;

import data_structure.list.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class InsertIntoCyclicSortedList708Test {
    InsertIntoCyclicSortedList708 solution;

    @Before
    public void setUp() {
        solution = new InsertIntoCyclicSortedList708();
    }

    @Test
    public void insertIntoEmptyList() {
        ListNode resHead = solution.insert(null, 1);
        assertThat(resHead.val,equalTo(1));
        assertNull(resHead.next);
    }

    @Test
    public void insertGreaterIntoSingleElementList() {
        // Given
        ListNode head = new ListNode(1);
        head.next = head;
        int insertVal = 2;
        // When
        ListNode resHead = solution.insert(head, insertVal);
        // Then
        assertThat(resHead == head, is(true));
        assertThat(resHead.next.val, equalTo(insertVal));
        assertThat(resHead.next.next == head, is(true));
    }

    @Test
    public void insertSmallerIntoSingleElementList() {
        // Given
        ListNode head = new ListNode(1);
        head.next = head;
        int insertVal = 0;
        // When
        ListNode resHead = solution.insert(head, insertVal);
        // Then
        assertThat(resHead == head, is(true));
        assertThat(resHead.next.val, equalTo(insertVal));
        assertThat(resHead.next.next == head, is(true));
    }

    @Test
    public void insertIntoEqualElementsList() {
        // Given
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        int insertVal = 2;
        // When
        ListNode resHead = solution.insert(node1, insertVal);
        // Then
        assertThat(resHead == node1, is(true));
        assertThat(isListCyclicSortedWithValuePresent(resHead, insertVal, 0), is(true));
    }

    @Test
    public void insertIntoEndOfSortedPart(){
        // Given
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        int insertVal = 7;
        // When
        ListNode resHead = solution.insert(node2, insertVal);
        // Then
        assertThat(resHead == node2, is(true));
        assertThat(isListCyclicSortedWithValuePresent(resHead, insertVal, 0), is(true));
    }

    @Test
    public void insertBeforeSortedPart(){
        // Given
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        int insertVal = 0;
        // When
        ListNode resHead = solution.insert(node2, insertVal);
        // Then
        assertThat(resHead == node2, is(true));
        assertThat(isListCyclicSortedWithValuePresent(resHead, insertVal, 0), is(true));
    }

    @Test
    public void insertIntoListWhereSameValuePresent(){
        // Given
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;
        int insertVal = 3;
        // When
        ListNode resHead = solution.insert(node3, insertVal);
        // Then
        assertThat(resHead == node3, is(true));
        assertThat(isListCyclicSortedWithValuePresent(resHead, insertVal, 2), is(true));
    }

    /**
     *
     * @param head start node of the cyclic sorted list
     * @param valToCheck inserted value
     * @param sameValueCount number of nodes with same value as inserted
     * @return true if resulting list is cyclic sorted and number of nodes with same value as inserted is exactly 1 more
     * than in initial list
     */
    private boolean isListCyclicSortedWithValuePresent(ListNode head, int valToCheck, int sameValueCount) {
        // we assume that list remains cyclic, so no check for cycle
        ListNode curNode = head;
        ListNode nextNode = head.next;
        int insertedValueCount = 0;
        // in cyclic sorted list there should be not more than 1 drop (i.e. in 1->2->3->1 3->1 is a drop)
        int dropCount = 0;
        do {
            if (curNode.val == valToCheck) {
                insertedValueCount++;
            }
            if (nextNode.val < curNode.val) {
                dropCount++;
            }
            if (dropCount > 1) {
                return false; // list is unsorted
            }
            curNode = nextNode;
            nextNode = curNode.next;
        } while (curNode != head);
        return insertedValueCount > 0 && insertedValueCount == sameValueCount + 1;
    }
}