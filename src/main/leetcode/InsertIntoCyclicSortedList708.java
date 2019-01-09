package leetcode;

import data_structure.list.ListNode;

public class InsertIntoCyclicSortedList708 {
    public ListNode insert(ListNode head, int insertVal) {
        if (head == null) {
            head = new ListNode(insertVal);
            return head;
        }
        ListNode curNode = head;
        ListNode nextNode = head.next;
        while (true) {
            if (nextNode.val > curNode.val) {
                if (insertVal >= curNode.val && insertVal <= nextNode.val) {
                    insertNode(curNode, insertVal);
                    break;
                }
            } else { // next <= cur
                if (insertVal <= nextNode.val && insertVal <= curNode.val) {
                    insertNode(curNode, insertVal);
                    break;
                } else if (insertVal >= curNode.val) {
                    insertNode(curNode, insertVal);
                    break;
                }
            }
            curNode = nextNode;
            nextNode = curNode.next;
        }
        return head;
    }

    private void insertNode(ListNode curNode, int insertVal) {
        ListNode node = new ListNode(insertVal);
        ListNode nextNode = curNode.next;
        curNode.next = node;
        node.next = nextNode;
    }
}