package com.ds.recursion;
import java.util.HashMap;

public class CoinChange {
    public static HashMap<Integer, Integer> memoization = new HashMap<Integer, Integer>();

    public static int coinChange(int []coins, int target) {

        int answer = 1000;
        if(target == 0) {
            return 0;
        }

        if(target < 0) {
            return 1000;
        }
        for(int i=0; i<coins.length; i++) {
            answer = Math.min( answer, coinChange(coins, (target - coins[i])));
        }
        return answer + 1;
    }

    public static void main(String []args) {

        int []coins = {5,4,1};
        System.out.println(coinChange(coins, 50));

    }
}
