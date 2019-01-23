package leetcode;

import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 *
 * Follow up:
 *
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class FindMedianFromDataStream295 {
    private PriorityQueue<Integer> minHeap; // tracks Kth maximum number
    private PriorityQueue<Integer> maxHeap; // tracks Kth minimum number
    private int streamLength;
    private int heapSizeLimit; // mentioned as K above

    /** initialize your data structure here. */
    public FindMedianFromDataStream295() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        streamLength = 0;
        heapSizeLimit = 0;
    }

    /**
     * API of median finder - adds new element to data stream, from which median is expected to be calculated
     * @param num new element in the stream
     */
    public void addNum(int num) {
        streamLength++;
        heapSizeLimit = (streamLength + 1) / 2;
        addToMinHeap(num);
        addToMaxHeap(num);
    }

    /**
     * API of the median finder
     * @return median of all the elements in the stream seen so far
     */
    public double findMedian() {
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

    private void addToMinHeap(int num) {
        if (minHeap.isEmpty()) {
            minHeap.add(num);
        } else if (minHeap.size() < heapSizeLimit) {
            if (num < minHeap.peek()) {
                if (num >= maxHeap.peek()) {
                    minHeap.add(num);
                } else {
                    minHeap.add(maxHeap.peek());
                }
            } else {
                minHeap.add(num);
            }
        } else {
            if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
    }

    private void addToMaxHeap(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
        } else if (maxHeap.size() < heapSizeLimit) {
            if (num > maxHeap.peek()) {
                if (num <= minHeap.peek()) {
                    maxHeap.add(num);
                } else {
                    maxHeap.add(minHeap.peek());
                }
            } else {
                maxHeap.add(num);
            }
        } else {
            if (num < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(num);
            }
        }
    }
}
