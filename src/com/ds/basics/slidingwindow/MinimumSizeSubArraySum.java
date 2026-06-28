package com.ds.basics.slidingwindow;

/**
 * Code No: 209 - Minimum Size Sub Array Sum
 *
 * @author Karthikeyan
 */
public class MinimumSizeSubArraySum {

    /**
     * Minimum Size Sub Array Sum.
     *
     * @param a []int
     * @param limit int
     * @return []int
     */
    public static int[] minSizeSubArySum(int []a, int limit) {
        int left=0;
        int sum=0;
        int []ans = new int[]{-1,-1,Integer.MAX_VALUE};
        for(int right=0; right<a.length; right++) {
            sum=sum+right;
            while (left <= right && sum >= limit) {
                int len = right - left + 1;
                if(len < ans[2]) {
                    ans[0] = left;
                    ans[1] = right;
                    ans[2] = len;
                }
                sum = sum - a[left];
                left++;
            }
        }
        return ans;
    }

    public static void main(String []args) {
        int []a = {2,3,1,4,2,3};
        int []ans = minSizeSubArySum(a, 7);
        for(int i=0; i<ans.length; i++) {
            System.out.println(a[i]);
        }
    }
}
