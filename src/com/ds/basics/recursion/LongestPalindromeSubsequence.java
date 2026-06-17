package com.ds.basics.recursion;

/**
 * Longest Palindrome Subsequence. Recursion.
 *
 * @author kvaradha
 */
public class LongestPalindromeSubsequence {

    /**
     * Longest Palindrome Subsequence.
     *
     * @param str char[]
     * @param l int
     * @param r int
     * @return int
     */
    public static int lps(char []str, int l, int r) {
        if(l > r) {
            return 0;
        }
        if(l==r) {
            return 1;
        }
        int answer = 0;
        if(str[l] == str[r]) {
            // Forward one step.
            // Backward one step.
            // str[l] and str[r] two character matches. Hence, 2 added.
            answer = 2 + lps(str, l+1, r-1);
        } else {
            int a = lps(str, l+1, r);
            int b = lps(str, l, r-1);
            answer = Math.max(a,b);
        }
        return answer;
    }

    public static void main(String []args) {
        String str = "malaaayalamaaa";
        System.out.println(lps(str.toCharArray(), 0, str.length()-1));
    }
}
