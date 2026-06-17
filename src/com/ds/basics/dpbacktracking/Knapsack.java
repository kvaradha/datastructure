package com.ds.basics.dpbacktracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Knapsack - Bounded Approach - 2D Array.
 * Includes Backtracking.
 *
 * @author Karthikeyan.
 */
public class Knapsack {

    /**
     * Find Knapsack Path
     *
     * @param weights int[]
     * @param values int[]
     * @param capacity int
     * @return List<Integer>
     */
    public static List<Integer> findKnapsackPath(int []weights, int []values, int capacity) {
        int [][]dp = knapsack(weights, values, capacity);
        System.out.println("Maximum Value: " + dp[capacity][weights.length]);
        return findListedPath(dp, weights, capacity);
    }

    /**
     * Knapsack Bounded Approach.
     *
     * @param weights int[]
     * @param values int[]
     * @param capacity int
     * @return int[][]
     */
    public static int[][] knapsack(int []weights, int []values, int capacity) {
        int [][]dp = new int[capacity+1][weights.length+1];
        for(int i=1; i<=capacity; i++) {
            for(int j=1; j<=weights.length; j++) {
                int subproblem = i-weights[j-1];
                if(subproblem >= 0) {
                    //Formulae are similar to recursion.
                    //Reduce the weight index always.
                    dp[i][j] = Math.max(dp[i][j-1], values[j-1] + dp[subproblem][j-1]);
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp;
    }

    /**
     * Find List Path.
     *
     * @param dp int[][]
     * @param weights int[]
     * @param capacity int
     * @return List<Integer>
     */
    public static List<Integer> findListedPath(int [][]dp, int []weights, int capacity) {
        int targetCapacity = capacity;
        List<Integer> visited = new ArrayList<>();
        for(int i = weights.length; i>0; i--) {
            if(dp[capacity][i] != dp[capacity][i-1]) {
                visited.add(weights[i-1]);
                capacity = capacity - weights[i-1];
            }
        }
        return visited;
    }


    public static void main(String []args) {
        // Arrays are guaranteed to have the same length
        int[] weights = {2, 3, 4, 5};
        int[] values = {10, 20, 30, 40};
        // Maximum weight
        int capacity = 5;
        List<Integer> visited =  findKnapsackPath(weights, values, capacity);
        for(Integer path : visited) {
            System.out.print(path + " ");
        }
    }
}
