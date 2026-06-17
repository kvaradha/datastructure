package com.ds.basics.memoization;

import java.util.HashMap;
import java.util.Objects;

/**
 * Longest Common Subsequence - Memoization
 *
 * @author Karthikeyan
 */
public class LongestCommonSubsequence {

    public static HashMap<Points, Integer> memoization = new HashMap<>();

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
        Points p = new Points(i,j);
        // Check if the data is in memory first.
        if(memoization.get(p) != null) {
            return memoization.get(p);
        }
        if(i >= a.length || j >= b.length) {
            return 0;
        }
        int answer = 0;
        if(a[i] == b[j]) {
            answer = lcs(a, b, i+1, j+1) + 1;
        } else {
            //Left result.
            int lr = lcs(a,b, i+1, j);
            //Right result.
            int rr = lcs(a,b,i,j+1);
            answer = Math.max(lr,rr);
        }
        Points p1 = new Points(i,j);
        memoization.put(p1,answer);
        return answer;
    }

    /**
     * Tracker for memoization.
     */
    public static class Points {
        int n;
        int m;

        public Points(int n, int m) {
            this.n = n;
            this.m = m;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Points points = (Points) o;
            return n == points.n && m == points.m;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, m);
        }
    }

    public static void main(String []args) {
        int []a = {1, 4, 5, 6, 9, 10, 11};
        int []b = {6, 4, 9, 5, 9, 11};
        System.out.println(lcs(a, b, 0, 0));
    }
}
