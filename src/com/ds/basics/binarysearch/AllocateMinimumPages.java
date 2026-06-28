package com.ds.basics.binarysearch;

import java.util.Arrays;

/**
 * Code No: 410 - Split Array Largest Sum
 *
 * @author Karthikeyan
 */
public class AllocateMinimumPages {

    /**
     * Allocate minimum page - Binary Search
     * @param arr int[]
     * @param k int
     * @return int
     */
    public static int allocateMinPageBs(int []arr, int k) {
        int sum = 0;
        int max = 0;
        for(int ele : arr) {
            sum = sum + ele;
        }
        for(int ele : arr) {
            if(ele > max) {
                max = ele;
            }
        }
        int low = max;
        int high = sum;
        int res = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(check(arr, mid, k)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    /**
     * Allocate minimum page - brute force
     *
     * @param arr int[]
     * @param k int
     * @return int
     */
    public static int allocateMinimumPage(int []arr, int k) {
        int sum = 0;
        int max = 0;
        for(int ele : arr) {
            sum = sum + ele;
        }
        for(int ele : arr) {
            if(ele > max) {
                max = ele;
            }
        }
        for(int i=max; i<=sum; i++) {
            if(check(arr, i, k)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean check(int []arr, int pageLimit, int k) {
        int sum = 0;
        int count = 0;
        for(int ele : arr) {
            if((sum + ele) > pageLimit) {
                count = count + 1;
                sum = ele;
            } else {
                sum = sum + ele;
            }
        }
        return (count + 1 <= k);
    }

    public static void main(String []args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println(allocateMinimumPage(arr, k));
        System.out.println(allocateMinPageBs(arr, k));
    }

}
