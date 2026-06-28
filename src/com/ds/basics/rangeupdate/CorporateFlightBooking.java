package com.ds.basics.rangeupdate;

import java.util.Arrays;

/**
 * Code No: 1109 - Corporate Flight Booking.
 *
 * @author Karthikeyan
 */
public class CorporateFlightBooking {


    /**
     * Corporate Booking. This is nothing but range addition.
     * But starts from index 1. Hence, added +1 to the length.
     *
     * @param bookings int[][]
     * @param n int
     * @return int[]
     */
    public static int[] corporateBooking(int [][]bookings, int n) {
        n++;
        int []output = new int[n];
        for(int []booking : bookings) {
            int left = booking[0];
            int right = booking[1];
            int seats = booking[2];
            output[left] = output[left] + seats;
            if(right + 1 < n) {
                output[right + 1] = output[right + 1] - seats;
            }
        }
        for(int i=1; i<output.length; i++) {
            output[i] = output[i] + output[i-1];
        }
        return output;
    }

    public static void main(String []args) {
        int [][]bookings = {{1,2,10}, {2,3,20}, {2,5,25}};
        int n=5;
        Arrays.stream(corporateBooking(bookings, n)).forEach(e -> System.out.print(e + " "));
    }
}
