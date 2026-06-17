package com.ds.basics.dp;

public class HouseRobber {

    public static int houseRobber(int []arr, int len) {

        int []dp = new int[arr.length];

        dp[0] = 0;
        dp[1] = arr[0];
        for(int i = 2; i <= len; i++) {
            dp[i] = Math.max(arr[i] + dp[i-2], dp[i-1]);
        }
        return dp[arr.length - 1];
    }

    public static void main(String []args) {
        int []arr = {5, 3, 4, 11, 2};

        System.out.println(houseRobber(arr, arr.length -1));
    }
}
