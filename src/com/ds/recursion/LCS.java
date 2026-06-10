package com.ds.recursion;

public class LCS {

    public static int lcs(int []a, int []b, int n, int m) {

        if(n >= a.length || m >= b.length) {
            return 0;
        }

        int answer = 0;
        if(a[n] == b[m]) {
          answer =  lcs(a,b, n+1, m+1) + 1;
        } else if (a[n] != b[m]) {
          int aa =  lcs(a,b, n+1, m);
          int bb =   lcs(a,b, n , m+1);
          answer = Math.max(aa, bb);
        }

        return answer;
    }


    public static void main(String []args) {
        int a[] = {1,4,5,6,9,10,11};
        int b[] = {6,4,9,5,9,11};
        System.out.println(lcs(a,b,0,0));
    }
}
