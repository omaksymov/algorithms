package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindMedianFromDataStream295Test {
    private static final double EPS = 0.00001;

    @Test
    public void findMedian_OneNumber() {
        FindMedianFromDataStream295 obj = new FindMedianFromDataStream295();
        obj.addNum(7);
        double median = obj.findMedian();
        assertEquals(7.0, median, EPS);
    }

    @Test
    public void findMedian_TwoNumbers() {
        FindMedianFromDataStream295 obj = new FindMedianFromDataStream295();
        obj.addNum(7);
        obj.addNum(10);
        double median = obj.findMedian();
        assertEquals(8.5, median, EPS);
    }

    @Test
    public void findMedian_ThreeNumbers() {
        FindMedianFromDataStream295 obj = new FindMedianFromDataStream295();
        obj.addNum(1);
        obj.addNum(2);
        assertEquals(1.5, obj.findMedian(), EPS);
        obj.addNum(3);
        assertEquals(2, obj.findMedian(), EPS);
    }

    @Test
    public void findMedian_TenNumbers() {
        FindMedianFromDataStream295 obj = new FindMedianFromDataStream295();
        obj.addNum(2);
        obj.addNum(15);
        assertEquals(8.5, obj.findMedian(), EPS);
        obj.addNum(7);
        assertEquals(7, obj.findMedian(), EPS);
        obj.addNum(11);
        assertEquals(9, obj.findMedian(), EPS);
        obj.addNum(3);
        assertEquals(7, obj.findMedian(), EPS);
        obj.addNum(20);
        assertEquals(9, obj.findMedian(), EPS);
        obj.addNum(-4);
        assertEquals(7, obj.findMedian(), EPS);
        obj.addNum(0);
        assertEquals(5, obj.findMedian(), EPS);
        obj.addNum(-2);
        assertEquals(3, obj.findMedian(), EPS);
        obj.addNum(1);
        assertEquals(2.5, obj.findMedian(), EPS);
    }

    @Test
    public void findMedian_LeetCodeMediumTest() {
        FindMedianFromDataStream295 obj = new FindMedianFromDataStream295();
        obj.addNum(40);
        assertEquals(40, obj.findMedian(), EPS);
        obj.addNum(12);
        assertEquals(26, obj.findMedian(), EPS);
        obj.addNum(16);
        assertEquals(16, obj.findMedian(), EPS);
        obj.addNum(14);
        assertEquals(15, obj.findMedian(), EPS);
        obj.addNum(35);
        assertEquals(16, obj.findMedian(), EPS);
        obj.addNum(19);
        assertEquals(17.5, obj.findMedian(), EPS);
        obj.addNum(34);
        assertEquals(19, obj.findMedian(), EPS);
        obj.addNum(35);
        assertEquals(26.5, obj.findMedian(), EPS);
        obj.addNum(28);
        assertEquals(28, obj.findMedian(), EPS);
        obj.addNum(35);
        assertEquals(31, obj.findMedian(), EPS);
        obj.addNum(26);
        assertEquals(28, obj.findMedian(), EPS);
        obj.addNum(6);
        assertEquals(27, obj.findMedian(), EPS);
        obj.addNum(8);
        assertEquals(26, obj.findMedian(), EPS);
        obj.addNum(2);
        assertEquals(22.5, obj.findMedian(), EPS);
        obj.addNum(14);
        assertEquals(19, obj.findMedian(), EPS);
        obj.addNum(25);
        assertEquals(22, obj.findMedian(), EPS);
        obj.addNum(25);
        assertEquals(25, obj.findMedian(), EPS);
        obj.addNum(4);
        assertEquals(22, obj.findMedian(), EPS);
        obj.addNum(33);
        assertEquals(25, obj.findMedian(), EPS);
        obj.addNum(18);
        assertEquals(22, obj.findMedian(), EPS);
        obj.addNum(10);
        assertEquals(19, obj.findMedian(), EPS);
        obj.addNum(14);
        assertEquals(18.5, obj.findMedian(), EPS);
        obj.addNum(27);
        assertEquals(19.0, obj.findMedian(), EPS);
        obj.addNum(3);
        assertEquals(18.5, obj.findMedian(), EPS);
        obj.addNum(35);
        assertEquals(19, obj.findMedian(), EPS);
        obj.addNum(13);
        assertEquals(18.5, obj.findMedian(), EPS);
        obj.addNum(24);
        assertEquals(19, obj.findMedian(), EPS);
        obj.addNum(27);
        assertEquals(21.5, obj.findMedian(), EPS);
        obj.addNum(14);
        assertEquals(19, obj.findMedian(), EPS);
        obj.addNum(5);
        assertEquals(18.5, obj.findMedian(), EPS);
        obj.addNum(0);
        assertEquals(18, obj.findMedian(), EPS);
        obj.addNum(38);
        assertEquals(18.5, obj.findMedian(), EPS);
        obj.addNum(19);
        assertEquals(19, obj.findMedian(), EPS);
        obj.addNum(25);
        assertEquals(19, obj.findMedian(), EPS);
        obj.addNum(11);
        assertEquals(19, obj.findMedian(), EPS);
        obj.addNum(14);
        assertEquals(18.5, obj.findMedian(), EPS);
        obj.addNum(31);
        assertEquals(19, obj.findMedian(), EPS);
        obj.addNum(30);
        assertEquals(19, obj.findMedian(), EPS);
        obj.addNum(11);
        assertEquals(19, obj.findMedian(), EPS);
        obj.addNum(31);
        assertEquals(19, obj.findMedian(), EPS);
        obj.addNum(0);
        assertEquals(19, obj.findMedian(), EPS);
    }
}