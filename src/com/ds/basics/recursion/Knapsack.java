package com.ds.basics.recursion;

/**
 * Knapsack - Recursion
 *
 * @author Karthikeyan
 */
public class Knapsack {

    /**
     * Knapsack.
     *
     * @param weights int[]
     * @param values int[]
     * @param capacity int
     * @param wi int
     * @return int
     */
    public static int knapsack(int[] weights, int[] values, int capacity, int wi) {
        if(capacity == 0 || wi < 0) {
            return 0;
        }
        int answer = 0;
        int include = 0;
        int exclude = 0;
        if(capacity >= weights[wi]) {
            //Include.
            include = values[wi] + knapsack(weights, values, capacity - weights[wi], wi - 1);
        }
        //Exclude.
        exclude = knapsack(weights,values,capacity, wi-1);
        //Find max value.
        answer = Math.max(include, exclude);
        return answer;
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
