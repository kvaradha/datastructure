package com.ds.dp;

import java.util.Arrays;
import java.util.HashMap;

public class CoinChange {



    public static int coinChange(int []coins, int target, int []dp) {
        dp[0] = 0;
        for(int i=1; i <= target; i++) {
            for(int j=0; j< coins.length; j++) {
                int subproblem = i - coins[j];
                if(subproblem < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[subproblem] + 1);
            }
        }
        return dp[target];
    }

    public static void main(String args[]) {

        int []coins = {5,4,1};
        int target = 13;
        int []dp = new int[target+1];
        Arrays.fill(dp, 1000);
        System.out.println(coinChange(coins, target, dp));

    }
}
