package com.ds.dp;

public class LCS {

    public static int lcs(int []a, int []b) {
        int [][]dp = new int[a.length + 1][b.length + 1];
        int sol = 0;
        for(int i=1; i<=a.length; i++) {
            for(int j=1; j<=b.length; j++) {
                if (a[i-1] == b[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length][b.length];
    }

    public static void main(String []args) {
        int a[] = {1,4,5,6,9,10,11};
        int b[] = {6,4,9,5,9,11};
        System.out.println(lcs(a,b));
    }
}
