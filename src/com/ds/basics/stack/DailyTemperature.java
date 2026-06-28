package com.ds.basics.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Code No: 739 - Daily Temperature
 *
 * @author Karthikeyan
 */
public class DailyTemperature {

    /**
     * Daily Temperature
     *
     * @param temp int[]
     * @return int[]
     */
    public static int[] dailyTemperatures(int []temp) {
        List<Integer> stack = new ArrayList<>();
        int []output = new int[temp.length];
        int right = 0;
        while(right < temp.length) {
            if(stack.isEmpty() || temp[stack.getLast()] >= temp[right]) {
                //Ex: 69 can be added on top of 71.
                stack.addLast(right);
                right ++;
            } else {
                int poppedIndex = stack.removeLast();
                output[poppedIndex] = right - poppedIndex;
            }
        }
        return output;
    }

    public static void main(String []args) {
        // Input: temperatures = [73,74,75,71,69,72,76,73]
        // Output: [1,1,4,2,1,1,0,0]
        int []temperatures = {73,74,75,71,69,72,76,73};
        int []output = dailyTemperatures(temperatures);
        for(int ele : output) {
            System.out.print(ele + " ");
        }
    }
}
