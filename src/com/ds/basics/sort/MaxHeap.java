package com.ds.basics.sort;

import java.util.Arrays;

/**
 * Max Heap.
 *
 * @author Karthikeyan
 */
public class MaxHeap {

    /**
     * Build Heap - Rearrange Vector
     *
     * @param a int[]
     */
    public static void buildHeap(int []a) {
        int len = a.length;
        for(int i=len/2-1; i>=0; i--) {
            heapIfy(a,len,i);
        }
    }

    /**
     * Heap-ify
     *
     * @param a int[]
     * @param n int
     * @param i int
     */
    private static void heapIfy(int []a, int n, int i) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left < n && a[left] > a[largest]) {
            largest = left;
        }
        if(right < n && a[right] > a[largest]) {
            largest = right;
        }
        if(i != largest) {
            swap(a, i, largest);
            heapIfy(a,n,i);
        }
    }

    private static void swap(int []a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String []args) {
        int []a = {10,11,9,8,5,3,15,6};
        buildHeap(a);
        Arrays.stream(a).forEach(e -> System.out.print(e + " "));
    }
}
