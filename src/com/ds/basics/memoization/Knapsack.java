package com.ds.basics.memoization;

import java.util.HashMap;

/**
 * Knapsack - Memoization
 *
 * @author Karthikeyan.
 */
public class Knapsack {

    //Global variable for memoization concept.
    public static HashMap<Integer, Integer> memoization = new HashMap<>();

    /**
     * Knapsack
     *
     * @param weights int[]
     * @param values int[]
     * @param capacity int
     * @param wi int
     * @return int
     */
    public static int knapsack(int []weights, int []values, int capacity, int wi) {
        if(memoization.get(capacity) != null) {
            return memoization.get(capacity);
        }
        if(capacity == 0 || wi < 0) {
            return 0;
        }
        int answer = 0;
        int included = 0;
        int excluded = 0;
        if(capacity >= weights[wi]) {
            included = values[wi] + knapsack(weights, values, capacity-weights[wi], wi-1);
        }
        excluded =  knapsack(weights, values, capacity, wi-1);
        answer = Math.max(included, excluded);
        memoization.put(capacity, answer);
        return answer;
    }

    public static void main(String []args) {
        // Arrays are guaranteed to have the same length
        int[] weights = {2, 3, 4, 5};
        int[] values = {10, 20, 30, 40};
        // Max weight
        int capacity = 5;
        int n = weights.length;
        int maxProfit = knapsack(weights, values, capacity, weights.length-1);
        System.out.println("Maximum Value: " + maxProfit);
    }

}
