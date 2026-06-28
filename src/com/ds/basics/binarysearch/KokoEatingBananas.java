package com.ds.basics.binarysearch;

/**
 * Code No: 875 - Koko Eating Bananas
 *
 * @author Karthikeyan
 */
public class KokoEatingBananas {

    /**
     * Koko Eating Bananas
     *
     * @param piles int[]
     * @param hours int
     * @return int
     */
    public static int kokoEatingBananas(int []piles, int hours) {
        int low = 1;
        int high = 0;
        for(int pile : piles) {
            if(pile > high) {
                high = pile;
            }
        }
        int res = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(check(piles, mid, hours)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static boolean check(int []piles, int speed, int hours) {
        int totalHours = 0;
        for(int pile : piles) {
            totalHours = totalHours + (int) Math.ceil((double) pile / speed);
        }
        return totalHours <= hours;
    }

    public static void main(String []args) {
        int[] arr = new int[] {3,6,7,11};
        int k = 8;
        System.out.println(kokoEatingBananas(arr, k));
        arr = new int[] {30,11,23,4,20};
        k = 5;
        System.out.println(kokoEatingBananas(arr, k));
        arr = new int[] {30,11,23,4,20};
        k = 6;
        System.out.println(kokoEatingBananas(arr, k));
    }
}
