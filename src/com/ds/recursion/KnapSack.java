package com.ds.recursion;

public class KnapSack {

    // Main recursive function
    public static int knapsack(int[] weights, int[] values, int capacity, int wl) {
        if (capacity == 0 || wl <0) {
            return 0;
        }
        int include = 0;
        if(capacity >= weights[wl]) {
            include = values[wl] + knapsack(weights, values, capacity - weights[wl], wl - 1);
        }
        int exclude = knapsack(weights, values, capacity, wl-1);
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        // Arrays are guaranteed to have the same length
        int[] weights = {2, 3, 4, 5};
        int[] values = {10, 20, 30, 40};
        // Max weight
        int capacity = 5;
        int n = weights.length;

        int maxProfit = knapsack(weights, values, capacity, n-1);
        System.out.println("Maximum Value: " + maxProfit);
    }

}
