package datastructures;

/**
 * Created by vijaya on 3/16/2017.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class SortingTest {

    @Test
    public void testSort1() {
        int[] numbers = new int[] { 1, 7, 99, 2, 0, 12, 15 };
        Sorting.bubbleSort(numbers);
        assertArrayEquals(new int[] { 0, 1, 2, 7, 12, 15, 99 }, numbers);
    }

    @Test
    public void testSort2() {
        int[] numbers = new int[] { 8, 5, 3, 1, 9, 6, 0, 7, 4, 2, 5  };
        Sorting.bubbleSort(numbers);
        assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9 }, numbers);
    }

    @Test
    public void testSort3() {
        int[] numbers = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Sorting.bubbleSort(numbers);
        assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, numbers);
    }
}