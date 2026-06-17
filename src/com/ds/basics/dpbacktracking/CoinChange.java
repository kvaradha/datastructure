package com.ds.basics.dpbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Coin Change - Dynamic Programing - Unbounded - Unlimited coin supply.
 * Find minimum number of coins to reach the target. Plus associated coins.
 * Backtracking.
 *
 * @author Karthikeyan
 */
public class CoinChange {

    /**
     * Coin Change With Path.
     *
     * @param coins int[]
     * @param target int
     * @return int
     */
    public static int coinChangeWithPath(int []coins, int target) {
        int []dp = coinChange(coins, target);
        int ans = isValid(dp,target);
        if(ans == -1) {
            System.out.println("Invalid Target.");
            return -1;
        } else {
            List<Integer> visited = findPath(dp, coins, target);
            System.out.println(visited);
        }
        return 0;
    }

    /**
     * Coin Change.
     *
     * @param coins []int
     * @param target int
     * @return []int
     */
    private static int[] coinChange(int []coins, int target) {
        int []dp = new int[target+1];
        // IMPORTANT: Initialize all states from to max integer value.
        Arrays.fill(dp, Integer.MAX_VALUE);
        // Initialize the first value to 0.
        dp[0] = 0;
        for(int i=1; i<=target; i++) {
            for(int coin : coins) {
                int subproblem = i-coin;
                if(subproblem >= 0) {
                    //This check is more important. To prevent overflow issues.
                    if(dp[subproblem] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[subproblem] + 1);
                    }
                }
            }
        }
        return dp;
    }

    /**
     * Find Path.
     *
     * @param dp int[]
     * @param coins int[]
     * @param target int
     * @return List<Integer>
     */
    private static List<Integer> findPath(int []dp, int []coins ,int target) {
        List<Integer> visited = new ArrayList<>();
        int currentTarget = target;
        while(currentTarget > 0) {
            for(int coin : coins) {
                int subproblem = currentTarget - coin;
                if(subproblem >= 0) {
                    if(dp[currentTarget] == dp[subproblem] + 1) {
                        currentTarget = currentTarget - coin;
                        visited.add(coin);
                        break;
                    }
                }
            }
        }
        return visited;
    }

    /**
     * Is Valid.
     *
     * @param dp int[]
     * @param target int
     * @return int
     */
    private static int isValid(int []dp, int target) {
        // If dp[target] was never reached or updated, map it back to your -1 flag
        // Check added for safe return.
        return (dp[target] == Integer.MAX_VALUE) ? -1 : dp[target];
    }

    public static void main(String []args) {
        System.out.println(coinChangeWithPath(new int[]{5,4,1}, 13));
        System.out.println(coinChangeWithPath(new int[]{2}, 3));
    }
}
