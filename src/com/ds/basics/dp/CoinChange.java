package com.ds.basics.dp;

import java.util.Arrays;

/**
 * Coin Change - Dynamic Programing - Unbounded - Unlimited coin supply.
 * @author Karthikeyan
 */
public class CoinChange {

    /**
     * Coin Change.
     *
     * @param coins int
     * @param target int
     * @return int
     */
    public static int coinChange(int []coins, int target) {
        int []dp = new int[target + 1];
        // IMPORTANT: Initialize all states from to max integer value.
        Arrays.fill(dp, Integer.MAX_VALUE);
        //Initialize the first value to 0.
        dp[0] = 0;
        //Iterate from 1 to the target limit.
        for(int i=1;i<=target; i++) {
            for(int coin : coins) {
                int subproblem = i - coin;
                if(subproblem >= 0) {
                    //This check is more important. To prevent overflow issues.
                    if (dp[subproblem] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[subproblem] + 1);
                    }
                }
            }
        }
        // If dp[target] was never reached or updated, map it back to your -1 flag
        // Check added for safe return.
        return (dp[target] == Integer.MAX_VALUE) ? -1 : dp[target];
    }

    public static void main(String []args) {
        int []coins = {5,4,1};
        System.out.println(coinChange(coins, 3));

        int []coins1 = {2};
        System.out.println(coinChange(coins1, 3));
    }
}
