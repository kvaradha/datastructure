package com.ds.basics.dpbacktracking;

/**
 * Longest Palindrome Subsequence. 2D Array.
 * Includes Backtracking.
 *
 * @author Karthikeyan.
 */
public class LongestPalindromeSubsequence {

    /**
     * Longest Palindrome Subsequence.
     *
     * @param str char[]
     * @return int[][]
     */
    public static int[][] lps(char []str) {
        int len = str.length;
        int [][]dp = new int[len][len];
        for(int i=len; i>=0; i--) {
            for(int j=i+1; j<len; j++) {
                if(str[i] == str[j]) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        // Max length stores in dp[0][len-1]
        return dp;
    }

    /**
     * Find Path.
     *
     * @param dp int[]
     * @param str char[]
     * @return String
     */
    public static String findPath(int [][]dp, char []str) {
        int i=0;
        int j=str.length-1;
        StringBuilder left= new StringBuilder();
        StringBuilder right= new StringBuilder();
        while(i<=j) {
            if(i==j) {
                left.append(str[i]);
                break;
            } else if(str[i] == str[j]) {
                left.append(str[i]);
                right.append(str[j]);
                i++;
                j--;
            } else if(dp[i+1][j] > dp[i][j-1]) {
                i++;
            } else {
                j--;
            }
        }
        return left.append(right.reverse()).toString();
    }

    public static void main(String []args) {
        String str = "malaaayalamaaa";
        int [][]dp = lps(str.toCharArray());
        String output = findPath(dp, str.toCharArray());
        System.out.println(output);
    }
}
