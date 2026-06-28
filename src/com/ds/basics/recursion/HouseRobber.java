package com.ds.basics.recursion;

/**
 * Code No: 198 - House Robber - Recursion
 *
 * @author Karthikeyan
 */
public class HouseRobber {

    /**
     * House Robber.
     *
     * @param arr int[]
     * @param len int
     * @return int
     */
    public static int houseRobber(int []arr, int len) {
        if(len < 0) {
            return 0;
        }
        if(len == 0) {
            return arr[0];
        }
        int answer = 0;
        int include = arr[len] + houseRobber(arr, len-2);
        int exclude = houseRobber(arr, len-1);
        answer = Math.max(include, exclude);
        return answer;
    }

    public static void main(String []args) {
        int []arr = {5, 3, 4, 11, 2};
       System.out.println(houseRobber(arr, arr.length -1));
    }
}
