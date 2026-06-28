package com.ds.basics.sort;

/**
 * Quick Select - Find second max (or) third max etc.
 * Based on Quick Sort algorithm.
 *
 * @author Karthikeyan
 */
public class QuickSelect {

    /**
     * Quick Select Kth Element
     *
     * @param a int[]
     * @param left int
     * @param right int
     * @param k int
     * @return int
     */
    public static int quickSelect(int []a, int left, int right, int k) {
        if(left < right) {
            int mid = partition(a, left, right);
            int targetIndex = k - 1;
            if(mid == targetIndex) {
                return a[mid];
            } else if(mid < targetIndex) {
                return quickSelect(a, mid + 1, right, k);
            } else {
                return quickSelect(a, left, mid - 1, k);
            }
        }
        if(left == right) {
            return a[left];
        }
        return -1;
    }

    /**
     * Partition.
     *
     * @param a int[]
     * @param left int
     * @param right int
     * @return int
     */
    public static int partition(int []a, int left, int right) {
        int pivot = left;
        while (left < right) {
            while (left < right && a[left] <= a[pivot]) {
                left = left + 1;
            }
            while (a[right] > a[pivot]) {
                right = right - 1;
            }
            if (left < right) {
                swap(a, left, right);
            }
        }
        swap(a,right, pivot);
        return right;
    }

    /**
     * Swap two element.
     *
     * @param a int[]
     * @param i int
     * @param j int
     */
    public static void swap(int []a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String []args) {
        int []arr = {10,5,3,2,12};
        System.out.println(quickSelect(arr,0,arr.length-1, 2));
    }
}
