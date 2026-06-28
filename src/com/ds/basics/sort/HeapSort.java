package com.ds.basics.sort;

import java.util.Arrays;

/**
 * Heap Sort.
 *
 * @author Karthikeyan
 */
public class HeapSort {

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
     * Move the max heap to last and heapIfy
     *
     * @param a int[]
     */
    public static void heapSort(int []a) {
        int len = a.length;
        for(int i=len-1; i>0; i--) {
            swap(a, i, 0);
            heapIfy(a,i, 0);
        }
    }

    /**
     * Heap-Ify
     *
     * @param a int[]
     * @param n int
     * @param i int
     */
    public static void heapIfy(int []a, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < n && a[left] > a[largest]) {
            largest = left;
        }
        if(right < n && a[right] > a[largest]) {
            largest = right;
        }
        if(largest != i) {
            swap(a, largest, i);
            heapIfy(a,n,largest);
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
        System.out.println();
        heapSort(a);
        Arrays.stream(a).forEach(e -> System.out.print(e + " "));
    }
}
