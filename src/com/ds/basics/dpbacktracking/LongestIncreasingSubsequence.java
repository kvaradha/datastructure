package com.ds.basics.dpbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Longest Increasing Subsequence - 1D Dynamic programming.
 *
 * @author kvaradha
 */
public class LongestIncreasingSubsequence {

    /**
     * Find Longest Increasing Subsequence.
     *
     * @param nums int[]
     * @param dp dp[]
     * @return int
     */
    public static int lis(int []nums, int []dp) {
        Arrays.fill(dp, 1);
        int maxLength = 0;
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxLength = dp[i];
        }
        return maxLength;
    }

    /**
     * Find Longest Increasing Subsequence Path.
     * @param maxLength int
     * @param nums int[]
     * @param dp int[]
     * @return List<Integer>
     */
    public static List<Integer> findPath(int maxLength, int []nums, int []dp) {
        List<Integer> visited = new ArrayList<>();
        int prevValue = Integer.MAX_VALUE;
        for(int i=nums.length-1; i>=0; i--){
            if(dp[i] == maxLength && nums[i] < prevValue) {
                // Reduce the length by 1.
                maxLength = maxLength - 1;
                // Assign it to previous value. This is to check next bigger value.
                prevValue = nums[i];
                // Add the value to visited.
                visited.add(nums[i]);
            }
        }
        return  visited;
    }
    
    public static void main(String []args) {
        int[] nums = {10, 9, 10, 5, 3, 2, 101, 18, 20, 21};
        int []dp = new int[nums.length];
        int maxLength = LongestIncreasingSubsequence.lis(nums, dp);
        System.out.println(maxLength);
        List<Integer> visited = findPath(maxLength, nums, dp);
        System.out.println();
        for(Integer ele : visited) {
            System.out.print(ele + " ");
        }
    }
}
