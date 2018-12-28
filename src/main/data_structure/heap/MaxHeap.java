package data_structure.heap;

/**
 * MaxHeap is data structure visually represented as binary complete tree, where every node key is bigger or equal to
 * its children key. Complete tree means that all levels are completely filled except possibly the last level and the
 * last level has all the keys as left as possible.
 *
 *  Example:
 *
 *       9
 *     /  \
 *   8     6
 *  / \   /
 * 5  2  1
 * Array representation of the heap:
 * indexes: [0, 1, 2, 3, 4, 5]
 * array:   [9, 8, 6, 5, 2, 1]
 */
public class MaxHeap {
    private int[] a;
    private int capacity;
    private int size;

    public MaxHeap(int capacity) {
        a = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public void add(int x) {
        if (size < capacity) {
            a[size++] = x;
            int curPos = size - 1;
            int parentPos = parentIndex(curPos);
            while (a[curPos] > a[parentPos]) {
                swap(a, curPos, parentPos);
                curPos = parentPos;
                parentPos = parentIndex(curPos);
            }
        } else {
            throw new IllegalStateException("Capacity exceeded");
        }
    }

    public int size() {
        return size;
    }

    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int leftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    /**
     * Returns the top of the heap representing maximum value without removing it.
     *
     * @return top of the heap representing the maximum value.
     */
    public int peekMax() throws IllegalStateException {
        if (!isEmpty()) {
            return a[0];
        } else {
            throw new IllegalStateException("heap is empty");
        }
    }

    /**
     * Returns the top of the heap representing maximum value without removing it.
     *
     * @return top of the heap representing the maximum value.
     */
    public int pollMax() {
        if (isEmpty()) throw new IllegalStateException("heap is empty");
        int maxValue = a[0];
        a[0] = a[size - 1];
        size--;
        maxHeapify(0);
        return maxValue;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void maxHeapify(int curPosition) {
        if (curPosition >= size) return;
        if (isLeaf(curPosition)) return;
        int leftIndex = leftChildIndex(curPosition);
        int rightIndex = rightChildIndex(curPosition);

        if (leftIndex < size && a[curPosition] < a[leftIndex]
                || rightIndex < size && a[curPosition] < a[rightIndex]) {
            if (a[leftIndex] > a[rightIndex]) {
                swap(a, leftIndex, curPosition);
                maxHeapify(leftIndex);
            } else {
                swap(a, rightIndex, curPosition);
                maxHeapify(rightIndex);
            }
        }
    }

    private boolean isLeaf(int i) {
        return leftChildIndex(i) >= size
                && rightChildIndex(i) >= size;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }
}
