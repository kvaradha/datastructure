package com.ds.basics.twopointer;

import java.util.Arrays;

/**
 * Code No: 16 - 3Sum Closest
 *
 * @author Karthikeyan
 */
public class ThreeSumClosest {

    /**
     * Three Sum Closest
     *
     * @param arr int[]
     * @param target int
     * @return int
     */
    public static int threeSumClosest(int []arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        int closestSum = arr[0] + arr[1] + arr[3];
        // Since it is triplet -2.
        for(int i=0; i<len-2; i++) {
            int left = i+1;
            int right = len - 1;
            while(left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if(target == sum) {
                    return sum;
                }
                if(Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                if(target > sum) {
                    right --;
                } else {
                    left ++;
                }
            }
        }
        return closestSum;
    }

    public static void main(String []args) {
        // Input: nums = [-1,2,1,-4], target = 1
        // Output: 2
        int []arr = {-1,2,1,-4};
        System.out.println(threeSumClosest(arr, 1));
    }
}
