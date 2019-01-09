package leetcode;

import data_structure.list.ListNode;

import java.util.Stack;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may <b>not</b> modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * <p>
 * Example 1:
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * <p>
 * Example 2:
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList143 {

    static class Solution1 {
        public void reorderList(ListNode head) {
            ListNode curNode;
            Stack<ListNode> stack = new Stack<>();
            curNode = head;
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.next;
            }
            ListNode insertNode;
            curNode = head;
            ListNode nextNode = curNode.next;
            while (nextNode != null && !stack.empty()) {
                insertNode = stack.pop();
                if (insertNode == nextNode) break;
                insertNode(curNode, insertNode, nextNode, stack);
                curNode = nextNode;
                nextNode = nextNode.next;
            }
        }


        private void insertNode(ListNode curNode, ListNode insertNode, ListNode nextNode, Stack<ListNode> stack) {
            curNode.next = insertNode;
            insertNode.next = nextNode;
            if (!stack.empty()) {
                ListNode lastInStack = stack.peek();
                lastInStack.next = null;
            }
        }
    }

    static class Solution2 {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) return;
            ListNode slow = head;
            ListNode fast = head;
            // 1) find the middle
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode preMiddle = slow;
            // 2) reverse the part from the middle
            ListNode newMiddle = reverse(preMiddle.next);
            preMiddle.next = newMiddle;
            // 3) reorder one-by-one
            ListNode p1 = head;
            ListNode p2 = newMiddle;
            while (p1 != preMiddle) {
                preMiddle.next = p2.next;
                p2.next = p1.next;
                p1.next = p2;
                p1 = p2.next;
                p2 = preMiddle.next;
            }
        }

        // returns new head (tail of original)
        private ListNode reverse(ListNode head) {
            ListNode next = null;
            ListNode curNode = head;
            ListNode tmp;
            while (curNode != null) {
                tmp = curNode.next;
                curNode.next = next;
                next = curNode;
                curNode = tmp;
            }
            return next;
        }
    }
}
