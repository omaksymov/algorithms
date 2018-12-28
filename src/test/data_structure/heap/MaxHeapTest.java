package data_structure.heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxHeapTest {

    @Test
    public void addIncrementsSize() {
       MaxHeap heap = new MaxHeap(4);
       int size1 = heap.size();
       heap.add(3);
       heap.add(2);
       heap.add(5);
       int size2 = heap.size();
       heap.add(4);
       int size3 = heap.size();
       assertEquals(3, size2 - size1);
       assertEquals(1, size3 - size2);
    }

    @Test
    public void addDuplicateIncrementsSize() {
        MaxHeap heap = new MaxHeap(3);
        heap.add(1);
        heap.add(1);
        assertEquals(2, heap.size());
    }

    @Test(expected = IllegalStateException.class)
    public void addExceedsCapacity() {
        MaxHeap heap = new MaxHeap(1);
        heap.add(1);
        heap.add(2);
    }

    @Test
    public void peekMax_equalsMax() {
        MaxHeap maxHeap = new MaxHeap(3);
        maxHeap.add(5);
        maxHeap.add(1);
        assertEquals(5, maxHeap.peekMax());
    }

    @Test
    public void peekMax_doesNotRemoveMax() {
        MaxHeap maxHeap = new MaxHeap(5);
        maxHeap.add(5);
        maxHeap.add(1);
        maxHeap.add(3);
        maxHeap.add(13);
        int max = maxHeap.peekMax();
        int max2 = maxHeap.peekMax();
        assertEquals(max, max2);
    }

    @Test(expected = IllegalStateException.class)
    public void emptyHeapPeekThrowsException() {
        MaxHeap maxHeap = new MaxHeap(5);
        maxHeap.peekMax();
    }

    @Test
    public void pollMax_equalsMax() {
        MaxHeap maxHeap = new MaxHeap(5);
        maxHeap.add(5);
        maxHeap.add(1);
        maxHeap.add(13);
        maxHeap.add(3);
        assertEquals(13, maxHeap.pollMax());
    }

    @Test
    public void pollMax_removesMax() {
        MaxHeap maxHeap = new MaxHeap(5);
        maxHeap.add(5);
        maxHeap.add(1);
        maxHeap.add(13);
        maxHeap.add(3);
        int max1 = maxHeap.pollMax();
        int max2 = maxHeap.pollMax();
        assertNotEquals(max1, max2);
        assertEquals(5, max2);
    }

    @Test(expected = IllegalStateException.class)
    public void emptyHeapPollThrowsException() {
        MaxHeap maxHeap = new MaxHeap(5);
        maxHeap.pollMax();
    }

    @Test
    public void emptyHeap_isEmpty() {
        MaxHeap objectUnderTest = new MaxHeap(5);
        assertTrue(objectUnderTest.isEmpty());
    }

    @Test
    public void clearedHeap_isEmpty() {
        MaxHeap heap = new MaxHeap(5);
        heap.add(4);
        heap.add(12);
        heap.add(0);
        while(!heap.isEmpty()) {
            heap.pollMax();
        }
        assertTrue(heap.isEmpty());
    }

    @Test
    public void filledHeap_isNonEmpty(){
        MaxHeap heap = new MaxHeap(5);
        heap.add(1);
        heap.add(5);
        assertFalse(heap.isEmpty());
    }

    @Test
    public void filledAfterClearHeap_isNonEmpty(){
        MaxHeap heap = new MaxHeap(5);
        heap.add(1);
        heap.add(5);
        while (!heap.isEmpty()) {
            heap.pollMax();
        }
        heap.add(4);
        heap.add(6);
        assertFalse(heap.isEmpty());
    }
}