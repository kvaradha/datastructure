package com.ds.basics.sort;

import java.util.Arrays;

/**
 * Merge Sort
 *
 * @author Karthikeyan
 */
public class MergeSort {

    /**
     * Merge Sort
     *
     * @param a int[]
     * @param left int
     * @param right int
     */
    public static void mergeSort(int []a, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid+1, right);
            merge(a, left, right, mid);
        }
    }

    /**
     * Merge Two Arrays
     *
     * @param a int[]
     * @param left int
     * @param right int
     * @param mid int
     */
    public static void merge(int []a, int left, int right, int mid) {
        int li=0,ri=0;
        li = mid - left + 1;
        ri = right - mid;
        int []la = new int[li];
        int []ra = new int[ri];
        for(int i=0; i<li; i++) {
            la[i] = a[left + i];
        }
        for(int i=0; i<ri; i++) {
            ra[i] = a[mid + 1 + i];
        }
        int i=0;
        int j=0;
        int k=left;
        while(i<li && j<ri) {
            if(la[i] <= ra[j]) {
                a[k] = la[i];
                i++;
            } else {
                a[k] = ra[j];
                j++;
            }
            k++;
        }
        while(i<li) {
            a[k] = la[i];
            i++;
            k++;
        }
        while(j<ri) {
            a[k] = ra[j];
            j++;
            k++;
        }
    }

    public static void main(String []args) {
        int []arr = {10,5,3,2,12};
        mergeSort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach((e) -> System.out.print(e + " " ));
    }
}
