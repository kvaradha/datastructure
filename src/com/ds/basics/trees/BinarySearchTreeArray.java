package com.ds.basics.trees;

/**
 * Binary Search Tree Array
 *
 * @author Karthikeyan
 */
public class BinarySearchTreeArray {

    /**
     * Add
     * @param arr int[]
     * @param data int
     * @param index int
     * @return int[]
     */
    public static int[] add(int []arr, int data, int index) {
        if(arr[index] == 0) {
            arr[index] = data;
            return arr;
        }
        if(arr[index] > data) {
            arr = add(arr,data,index * 2 + 1);
        } else {
            arr = add(arr, data, index * 2 + 2);
        }
        return arr;
    }

    /**
     * inorder
     * @param arr int[]
     * @param index int
     * @param isParent boolean
     */
    public static void inorder(int []arr, int index, boolean isParent) {
        if(arr[index] == 0 && !isParent) {
            return;
        }
        inorder(arr, index * 2 + 1, false);
        System.out.print(arr[index] + " ");
        inorder(arr, index * 2 +2, false);
    }

    public static void main(String []args) {
        int []a = {20, 30, 40, 10, 12, 21};
        int []btree = new int[100];
        for(int ele : a){
            add(btree, ele, 0);
        }
        inorder(btree, 0, true);
    }
}
