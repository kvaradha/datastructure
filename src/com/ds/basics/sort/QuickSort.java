package com.ds.basics.sort;

import java.util.Arrays;

/**
 * Quick Sort
 *
 * @author Karthikeyan
 */
public class QuickSort {

    /**
     * Quick Sort
     *
     * @param a int[]
     * @param left int
     * @param right int
     */
    public static void quickSort(int []a, int left, int right) {
        if(left < right) {
            int mid = partition(a, left, right);
            quickSort(a,left, mid-1);
            quickSort(a,mid+1,right);
        }
    }

    /**
     * Partition
     *
     * @param a int[]
     * @param left int
     * @param right int
     * @return int
     */
    public static int partition(int []a, int left, int right) {
        int pivot = left;
        while(left < right) {
            while(left < right && a[left] < a[pivot]) {
                left = left + 1;
            }
            while(a[right] > a[pivot]) {
                right = right - 1;
            }
            if(left < right) {
                swap(a, left, right);
            }
        }
        swap(a, right, pivot);
        return right;
    }

    /**
     * Swap Two Input Elements.
     *
     * @param a int[]
     * @param left int
     * @param right int
     */
    private static void swap(int []a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    public static void main(String []args) {
        int []arr = {10,5,3,2,12};
        quickSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach((e) -> System.out.print(e + " "));
    }
}
