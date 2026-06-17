package com.ds.basics.dp;

/**
 * Coin Change - Dynamic Programing - 1D - Unbounded - Unlimited weight supply.
 *
 * @author Karthikeyan
 */
public class Knapsack {

    /**
     * Knapsack Problem
     *
     * @param values int[]
     * @param weights int[]
     * @param capacity int
     * @return int
     */
    public static int knapsack(int []values, int []weights, int capacity) {
        int []dp = new int[capacity+1];
        dp[0]=0;
        for(int i=1; i<=capacity; i++) {
            for (int j=0; j<weights.length; j++) {
                if(weights[j] > i) {
                    continue;
                }
                dp[i] = Math.max(values[j] + dp[i-weights[j]],dp[i]);
            }
        }
        return dp[capacity];
    }

    public static void main(String []args) {
        // Arrays are guaranteed to have the same length
        int[] weights = {2, 3, 4, 5};
        int[] values = {20, 20, 30, 40};
        // Max weight
        int capacity = 6;
        int n = weights.length;
        int maxProfit = knapsack(values, weights, capacity);
        System.out.println("Maximum Value: " + maxProfit);
    }
}
