package leetcode;

import data_structure.list.Node;

public class InsertIntoCyclicSortedList708 {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            return head;
        }
        Node curNode = head;
        Node nextNode = head.next;
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

    private void insertNode(Node curNode, int insertVal) {
        Node node = new Node(insertVal);
        Node nextNode = curNode.next;
        curNode.next = node;
        node.next = nextNode;
    }
}