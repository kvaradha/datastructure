package com.ds.basics.binarysearch;
/**
 * Code No: 1011 - Capacity To Ship Package Within D days.
 * Solution same as Allocate minimum pages.
 *
 * @author Karthikeyan
 */
public class CapacityToShipPackages {

    /**
     * Ship Within Days
     *
     * @param w int[]
     * @param days int
     * @return int
     */
    public static int shipWithinDays(int []w, int days) {
        int max = 0;
        int sum = 0;
        for(int ele : w) {
            if(ele > max) {
                max = ele;
            }
            sum = sum + ele;
        }
        int low = max;
        int high = sum;
        int res = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(checkCapacity(w, days, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static boolean checkCapacity(int []w, int days, int capacity) {
        int currentCapacity = 0;
        int count = 1;
        for(int ele : w) {
           if (currentCapacity + ele > capacity) {
               currentCapacity = 0;
               count = count + 1;
           }
           currentCapacity = currentCapacity + ele;
        }
        return count <= days;
    }

    public static void main(String []args) {
        int []w = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(w, days));
    }
}
