package com.ds.basics.binarysearch;

/**
 * Code No: 33 - Rotated Sorted Array.
 *
 * @author Karthikeyan.
 */
public class RotatedSortedArray {

    /**
     * Rotated Sorted Array.
     *
     * @param arr []int
     * @param ele int
     * @return int
     */
    public static int rotatedSortedArray(int []arr, int ele) {
        int low = 0;
        int high = arr.length - 1;
        //Same index is possible.
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] == ele) {
                return mid;
            }
            //If below condition is passed we can consider towards left is perfectly sorted.
            // Note: equals to check is not required for mid. Because, mid-check is validated
            // in if statement itself.
            if (arr[mid] >= arr[low]) {
                // If below condition is passed we can consider, your search element
                // is in left range for sure.
                if(ele >= arr[low] && ele < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // If it comes here we can consider towards right is perfectly sorted.
            // Note: equals to check is not required for mid. Because, mid-check is validated
            // in if statement itself.
            else {
                // If below condition is passed we can consider, your search element
                // is in right range for sure.
                if(ele > arr[mid] && ele <= arr[high]) {

                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String []args) {
        int []arr1 = {5,6,7,0,1,2,3,4};
        System.out.println(rotatedSortedArray(arr1, 2));
        int []arr2 = {4,5,6,7,0,1,2,3};
        System.out.println(rotatedSortedArray(arr2, 0));
        int []arr3 = {2,3,4,5,6,7,0,1};
        System.out.println(rotatedSortedArray(arr3, 1));
    }
}
