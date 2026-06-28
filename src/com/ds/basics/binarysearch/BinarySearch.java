package com.ds.basics.binarysearch;

/**
 * Binary Search.
 *
 * @author Karthikeyan.
 */
public class BinarySearch {
    /**
     * Return the index of the element. If not return -1.
     *
     * @param arr int[]
     * @param ele int
     * @return int
     */
    public static int binarySearch(int []arr, int ele) {
        int low = 0;
        int high = arr.length - 1;
        // Index at the same position is accepted.
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == ele) {
                return mid;
            } else if(arr[mid] < ele) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String []args) {
        int []arr = {5,6,10,11,12,15,20};
        System.out.println(binarySearch(arr, 5));
    }
}
