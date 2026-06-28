package com.ds.basics.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * Code No: 84 - Largest Rectangle In Histogram.
 *
 * @author Karthikeyan
 */
public class LargestRectangle {

    /**
     * Find Largest Rectangle In Histogram
     *
     * @param arr int[]
     * @return int
     */
    public static int largestRectangle(int []arr) {
        List<Integer> stack = new LinkedList<>();
        int right=0;
        int max=0;
        while(right < arr.length) {
            if(stack.isEmpty() || arr[stack.getLast()] <= arr[right]) {
                stack.addLast(right);
                right++;
            } else {
                max = Math.max(max, calculateArea(arr, stack, right));
            }
        }
        while (!stack.isEmpty()) {
            max = Math.max(max, calculateArea(arr, stack, right));
        }
        return max;
    }

    /**
     * Calculate Area.
     *
     * @param arr int[]
     * @param stack List<Integer>
     * @param right int
     * @return int
     */
    private static int calculateArea(int []arr, List<Integer> stack, int right) {
        // Note: Remove the last element first.
        // Before determining the width.
        // Because for this input: 30 20 50: output is 60
        int height = arr[stack.removeLast()];
        int width;
        if(stack.isEmpty()) {
            width = right;
        } else {
            width = right - stack.getLast() -1;
        }
        return width * height;
    }

    public static void main(String []args) {
        int []arr = {60,20,50,40};
        System.out.println(largestRectangle(arr));

        int []arr1 = {10,20,30,40,50,60,70,40};
        System.out.println(largestRectangle(arr1));

        int []arr2 = {60, 10, 50, 60};
        System.out.println(largestRectangle(arr2));

        int[] arr3 = {2, 1, 2};
        System.out.println(largestRectangle(arr3));
    }
}
