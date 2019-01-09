package data_structure.list;

public class SinglyLinkedList {

    private ListNode head;

    public SinglyLinkedList(ListNode head) {
        this.head = head;
    }

    public ListNode getHead() {
        return head;
    }

    public void add(ListNode node) {
        ListNode curNode = head;
        ListNode prevNode = head;
        while (curNode != null) {
            prevNode = curNode;
            curNode = curNode.next;
        }
        prevNode.next = node;
    }

    public void remove(ListNode node) {
        if (node == head && head.next == null) {
            head = null;
            return;
        }
        ListNode prevNode = head;
        ListNode curNode = head;
        while (curNode != node) {
            prevNode = curNode;
            curNode = curNode.next;
        }
        node.next = null;
        prevNode.next = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        ListNode curNode = head;
        while (curNode != null) {
            sb.append(curNode.val).append(',').append(' ');
            curNode = curNode.next;
        }
        if (head != null) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(']');
        return sb.toString();
    }

    public static SinglyLinkedList fromString(String str) {
        if (str == null || str.length() <= 2) return null;
        String[] strValues = str.substring(1, str.length() - 1).split(",");

        int curVal = Integer.valueOf(strValues[0].trim());
        ListNode head = new ListNode(curVal);
        SinglyLinkedList list = new SinglyLinkedList(head);
        int n = strValues.length;
        for (int i = 1; i < n; i++) {
            list.add(new ListNode(Integer.valueOf(strValues[i].trim())));
        }
        return list;
    }

    public SinglyLinkedList cloneList() {
        if (head == null) return null;
        ListNode newHead = new ListNode(head.val);
        ListNode oldCurNode = head.next, newCurNode = newHead;
        while (oldCurNode != null) {
            newCurNode.next = new ListNode(oldCurNode.val);
            newCurNode = newCurNode.next;
            oldCurNode = oldCurNode.next;
        }
        return new SinglyLinkedList(newHead);
    }
}
