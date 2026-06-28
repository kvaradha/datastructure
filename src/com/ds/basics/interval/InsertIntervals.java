package com.ds.basics.interval;

import java.util.Arrays;

/**
 * Code No: 57 - Insert Intervals
 *
 * @author Karthikeyan
 */
public class InsertIntervals {

    /**
     * Merge Intervals
     *
     * @param intervals [][]int
     * @return [][]int
     */
    public static int[][] mergeInterval(int [][]intervals) {
        int startIndex = 0;
        int outputIndex = 0;
        int [][]output = new int[intervals.length][2];
        //Sorting is mandatory.
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        //Assign the first(startIndex) value to max.
        int max = intervals[startIndex][1];
        for(int i=0; i<intervals.length; i++) {
            max =  Math.max(max, intervals[i][1]);
            if(i<intervals.length-1 && intervals[i+1][0] <= max) {
                continue;
            } else {
                output[outputIndex][0] = intervals[startIndex][0];
                output[outputIndex][1] = max;
                // Interval range is identify at ith value.
                // So start index is assigned to ith + 1.
                startIndex=i+1;
                outputIndex = outputIndex + 1;
                if(i<intervals.length-1) {
                    //Assign the first(startIndex) value to max.
                    max = intervals[startIndex][1];
                }
            }
        }
        return Arrays.copyOf(output, outputIndex);
    }

    /**
     * Insert Interval.
     * Add the 1D new interval at the last of the 2D interval. And simply perform merge interval.
     *
     * @param intervals int[][]
     * @param newInterval int[]
     * @return int[][]
     */
    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        int [][]tempInterval = new int[intervals.length + 1][2];
        tempInterval = Arrays.copyOf(intervals, intervals.length+1);
        tempInterval[intervals.length] = newInterval;
        return mergeInterval(tempInterval);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        // Expected Output: 1 5 6 9 (since [1,3] and [2,5] merge into [1,5])
        Arrays.stream(insertInterval(intervals, newInterval)).forEach((i) ->
                System.out.print(i[0] + " " + i[1] + " "));
    }
}
