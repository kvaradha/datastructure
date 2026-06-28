package com.ds.basics.prefixsum;

import java.util.Arrays;

/**
 * Code No: 303 - Range Sum Query
 *
 * @author Karthikeyan
 */
public class RangeSum {

    public static int[] prefixSum(int []nums) {
        int []ps = new int[nums.length + 1];
        for(int i=0; i<nums.length; i++) {
            ps[i+1] = ps[i] + nums[i];
        }
        return ps;
    }

    public static int sumRange(int []prefixSum, int left, int right) {
        // Sum from left to right = prefixSum[right+1] - prefixSum[left]
        // This works because prefixSum[right+1] contains sum up to index right
        // and prefixSum[left] contains sum up to index left-1
        return prefixSum[right + 1] - prefixSum[left];
    }

    public static void main(String []args) {
        int []nums = new int[] {-2, 0, 3, -5, 2, -1};
        Arrays.stream(prefixSum(nums)).forEach(e -> System.out.print(e + " "));
        int []prefixSum = prefixSum(nums);
        System.out.println();
        System.out.println(sumRange(prefixSum, 0,2));
        System.out.println(sumRange(prefixSum, 2,5));
        System.out.println(sumRange(prefixSum, 0,5));
    }
}
