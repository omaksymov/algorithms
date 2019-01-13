package leetcode;

import data_structure.list.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 *
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;
        ListNode nextNode;
        while (curNode != null) {
            nextNode = curNode.next;
            while (nextNode != null && nextNode.val == curNode.val) {
                curNode.next = nextNode.next;
                nextNode = curNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }
}
