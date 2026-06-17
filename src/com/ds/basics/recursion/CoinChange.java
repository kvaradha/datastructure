package com.ds.basics.recursion;

/**
 * Coin Change - Recursion - Unbounded - Unlimited coin supply.
 * @author Karthikeyan
 */
public class CoinChange {

    /**
     * Coin Change
     * @param coins int[]
     * @param target int
     * @return int
     */
    public static int coinChange(int []coins, int target) {
        if(target == 0) {
            return 0;
        }
        if (target < 0) {
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
        //For input {2} and target 3, answer will return max value if we skip below check.
        //Check added for safe return.
        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }

    public static void main(String []args) {
        int []coins = {5,4,1};
        System.out.println(coinChange(coins, 3));

        int []coins1 = {2};
        System.out.println(coinChange(coins1, 3));
    }
}