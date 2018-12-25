package data_structure.list;

/**
 * Singly linked list node
 */
public class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int val) {
        this(val, null);
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
