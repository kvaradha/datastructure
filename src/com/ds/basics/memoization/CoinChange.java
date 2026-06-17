package com.ds.basics.memoization;

import java.util.HashMap;

/**
 * Coin Change - Memoization - Unbounded - Unlimited coin supply.
 * @author Karthikeyan
 */
public class CoinChange {
    public static HashMap<Integer, Integer> memoization = new HashMap<>();

    /**
     * Coin Change.
     *
     * @param coins []int
     * @param target int
     * @return int
     */
    public static int coinChange(int []coins, int target) {
        if (memoization.get(target) != null) {
            return memoization.get(target);
        }
        if(target == 0) {
            return 0;
        }
        if(target < 0) {
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        for(int coin : coins) {
            int output = coinChange(coins, target - coin);
            if(output != -1) {
                output = output + 1;
                answer = Math.min(answer, output);
            }
        }
        //Check added for safe return.
        answer = (answer == Integer.MAX_VALUE) ? -1 : answer;
        memoization.put(target, answer);
        return answer;
    }

    public static void main(String []args) {
        int []coins = {5,4,1};
        System.out.println(coinChange(coins, 150));
    }
}