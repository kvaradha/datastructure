package com.ds.basics.dpbacktracking;

/**
 * Longest Common Subsequence - 2D Array
 * Includes Backtracking.
 *
 * @author Karthikeyan.
 */
public class LongestCommonSubsequence {

    /**
     * Fill 2D Array and Backtrack the path.
     *
     * @param a int[]
     * @param b int[]
     * @return String
     */
    public static String findPath(int []a, int []b) {
        int [][]dp = lcs(a,b);
        System.out.println("Longest Common Subsequence: " + dp[a.length][b.length]);
        return findPath(dp, a, b);
    }

    /**
     * Filling 2D array.
     *
     * @param a int[]
     * @param b int[]
     * @return int[][] - Return DP
     */
    private static int[][] lcs(int []a, int []b) {
        int [][]dp = new int[a.length+1][b.length+1];
        for(int i=1; i<=a.length; i++) {
            for(int j=1; j<=b.length; j++) {
                if(a[i-1] == b[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp;
    }

    /**
     * Backtracking the path.
     *
     * @param dp int[][]
     * @param a int[]
     * @param b int[]
     * @return String
     */
    private static String findPath(int [][]dp, int []a, int []b) {
        int i = a.length;
        int j = b.length;
        StringBuilder output = new StringBuilder();
        while(i > 0 && j > 0) {
            if(a[i-1] == b[j-1]) {
                // Should use string in condition.
                output.append(a[i-1]).append(" ");
                i--;
                j--;
            } else if(dp[i][j-1] > dp[i-1][j]) {
                // Should use 2D array in condition.
                j--;
            } else {
                i--;
            }
        }
        return output.reverse().toString();
    }

    public static void main(String []args) {
        // Physical array
        int []a = {1,4,5,6,9,10,11};
        // Physical array.
        int []b = {6,4,9,5,9,11};
        System.out.println(findPath(a,b));
    }
}
