package com.ds.basics.rangeupdate;

/**
 * Code No: 1094 - Car Pooling
 *
 * @author Karthikeyan
 */
public class CarPooling {

    /**
     * Car Pooling.
     *
     * @param trips int[][]
     * @param capacity int
     * @return boolean
     */
    public static boolean carPooling(int [][]trips, int capacity) {
        int []result = new int[capacity];
        for(int []trip : trips) {
            int passengers = trip[0];
            int left = trip[1];
            int right = trip[2];
            result[left] = result[left] + passengers;
            if(right + 1 < capacity) {
                result[right+1] = result[right+1] - passengers;
            }
        }
        int currentPassengers = 0;
        for(int i=0; i< result.length; i++) {
            currentPassengers = currentPassengers + result[i];
            if(currentPassengers > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String []args) {
        int [][]trips = new int[][]{{2,1,5},{3,3,7}};
        int capacity = 5;
        System.out.println(carPooling(trips, capacity));
    }
}
