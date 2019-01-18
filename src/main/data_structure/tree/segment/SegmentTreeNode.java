package data_structure.tree.segment;

public class SegmentTreeNode {
    int start;
    int end;
    int sum;
    SegmentTreeNode left;
    SegmentTreeNode right;

    /**
     * @param start left border of range, inclusively
     * @param end right border of range, inclusively
     */
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        sum = 0;
        left = null;
        right = null;
    }
}
