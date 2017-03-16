package datastructures;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by vijaya on 3/15/2017.
 */
public class Sorting {


    /**
     * This is the basic Bubble sort for sorting integers, unoptimized
     * with each pass, we compare element at i with element at i+1 and swap if not in order.
     * After each pass, the biggest element sinks to the bottom of the array.
     *
     */
    public static int[] bubbleSort(int[] unsorted) {
        System.out.println("Before  = " + printArray(unsorted));
        int n = unsorted.length;
        for (int k = 0; k < n-1; k++) {
            for (int i = 0; i < n - 1; i++) {
                if (unsorted[i] > unsorted[i + 1]) {
                    swap(unsorted, i, i+1);
                }
            }
            System.out.println("Pass " + k + ": " + printArray(unsorted));
        }
        System.out.println("Final = " + printArray(unsorted));
        return unsorted;

    }


    /**
     * This is Bubble sort, partially optmized.
     * with each pass, we compare element at i with element at i+1 and swap if not in order.
     *  Also with each pass, the biggest element sinks to the bottom of the array, so for the next pass, we
     * need to loop only from 0 to k-1  where k is initiliazed to n and decrement k after each pass.
     *
     */
    public static int[] bubbleSortPartOptimized(int[] unsorted) {
        System.out.println("Before  = " + printArray(unsorted));
        int n = unsorted.length;
       for (int k = n; k > 0; k--) {
            for (int i = 0; i < k - 1; i++) {
                if (unsorted[i] > unsorted[i + 1]) {
                    swap(unsorted, i, i+1);
                }
            }
            System.out.println("Pass " + k + ": " + printArray(unsorted));
        }
        System.out.println("Final = " + printArray(unsorted));
        return unsorted;

    }


    /**
     *
     * This version keeps track of whether there has been a swap during a pass, using a boolean swapped.
     * Use a While loop, so if there are no more swaps, the array is sorted and we can exit the loop.
     *
     *  Also with each pass, the biggest element sinks to the bottom of the array, so for the next pass, we
     * need to loop only from 0 to k-1  where k is initilazed to n and decrement k after each pass.
     *
     */
    public static int[] bubbleSortOptimized(int[] unsorted) {
        System.out.println("Before  = " + printArray(unsorted));
        int n = unsorted.length;
            boolean swapped = true;
        int k = n;
            while (swapped)  {
                swapped = false;
                for (int i = 0; i < k - 1; i++) {
                    if (unsorted[i] > unsorted[i + 1]) {
                        swap(unsorted, i, i+1);
                        swapped = true;


                    }
            }
            System.out.println("Pass " + k + ": " + printArray(unsorted));
            k--;
        }
        System.out.println("Final = " + printArray(unsorted));
        return unsorted;

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static String printArray(int[] arr) {
        String arrayp = new String();
        for (int i = 0; i < arr.length; i++) {
            arrayp = arrayp + arr[i] + "   ";
        }
        return arrayp;
    }


    public static void main(String[] args) {

    }


}
