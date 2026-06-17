package com.ds.basics.recursion;

/**
 * Longest Common Subsequence - Recursion
 *
 * @author Karthikeyan
 */
public class LongestCommonSubsequence {

    /**
     * Longest Common Subsequence
     *
     * @param a int[]
     * @param b int[]
     * @param i int - index of a
     * @param j int - index of b
     * @return int
     */
    public static int lcs(int []a, int []b, int i, int j) {
        if(i >= a.length || j >= b.length) {
            return 0;
        }
        int answer = 0;
        if(a[i] == b[j]) {
            // One character matches. So 1 added to the output.
            answer = 1 + lcs(a,b,i+1, j+1);
        } else {
            //Left result.
            int lr = lcs(a,b,i+1,j);
            //Right result.
            int rr = lcs(a,b,i,j+1);
            answer = Math.max(lr, rr);
        }
        return answer;
    }

    public static void main(String []args) {
        int []a = {1,4,5,6,9,10,11};
        int []b = {6,4,9,5,9,11};
        System.out.println(lcs(a,b,0,0));
    }
}
