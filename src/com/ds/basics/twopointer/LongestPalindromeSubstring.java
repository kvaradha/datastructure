package com.ds.basics.twopointer;


import java.util.Arrays;

/**
 * Longest Palindrome Substring. Expand from center concept.
 * Two pointers.
 *
 * @author Kathikeyan.
 */
public class LongestPalindromeSubstring {

    /**
     * Longest Palindrome Substring
     *
     * @param str char[]
     * @return String
     *
     */
    public static String lps(char []str) {
        int []oddResult = new int[2];
        int []evenResult = new int[2];
        int []max = new int[2];
        for(int i=0; i<str.length; i++) {
            expandFromCenter(str, i, i, oddResult);
            expandFromCenter(str,i,i+1,evenResult);
            int []temp = findMax(oddResult, evenResult);
            if(temp[1] > max[1]) {
                max[0] = temp[0];
                max[1] = temp[1];
            }
        }
        return new String(str, max[0], max[1]);
    }

    /**
     * Find Max
     * @param a int[]
     * @param b int[]
     * @return int[]
     */
    public static int[] findMax(int []a, int []b) {
        return a[1] > b[1] ? a : b;
    }

    /**
     * Expand From Center
     * @param str char[]
     * @param start int
     * @param end int
     * @param output int
     */
    public static void expandFromCenter(char []str, int start, int end, int []output) {
        while(start <= end && start >= 0 && end < str.length && str[start] == str[end]) {
            start--;
            end++;
        }
        // Start index.
        output[0] = start + 1;
        // End index or total length.
        output[1] = end-start-1;
    }

    public static void main(String []args) {
        String a = "babad";
        System.out.println(lps(a.toCharArray()));
        String b = "abracecarz";
        System.out.println(lps(b.toCharArray())); // Safely prints "bb"
    }
}
