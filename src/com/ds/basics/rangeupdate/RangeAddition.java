package com.ds.basics.rangeupdate;

import java.util.Arrays;

/**
 * Code No: 370 - Range Addition
 *
 * @author Karthikeyan
 */
public class RangeAddition {

    /**
     * Range Addition.
     *
     * @param length int
     * @param updates int[][]
     * @return int[]
     */
    public static int[] rangeAddition(int length, int [][]updates) {
        int []output = new int[length];
        for(int []update : updates) {
            int left =  update[0];
            int right = update[1];
            int num = update[2];
            output[left] = output[left] + num;
            if(right + 1 < length) {
                output[right + 1] = output[right + 1] - num;
            }
        }
        for(int i=1; i< length; i++) {
            output[i] = output[i] + output[i-1];
        }
        return output;
    }

    public static void main(String []args) {
        int [][]updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        Arrays.stream(rangeAddition(5, updates)).forEach(e -> System.out.print(e + " "));
    }
}
