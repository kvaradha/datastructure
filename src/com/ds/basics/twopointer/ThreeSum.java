package com.ds.basics.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Code No: 15 - 3Sum
 *
 * @author Karthikeyan
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int []arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int len = arr.length;
        // Iterate through the array as the first element of triplet
        // Stop at length-2 since we need at least 3 elements
        for(int i=0; i<len-2; i++) {
            // For the first iteration skip.
            // Second version compare with previous value.
            if(i > 0 && arr[i] == arr[i-1]) {
                continue;
            }
            int left = i+1;
            int right = len-1;
            while(left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                // Arrays are sorted.
                if(sum < 0) {
                    //If sum is less than zero. Then increase the left pointer.
                    left ++;
                } else if (sum > 0) {
                    // If sum is greater than zero. Then decrease the right pointer.
                    right--;
                } else {
                    left++;
                    right--;
                    result.add(List.of(arr[i], arr[left], arr[right]));
                    // left is incremented so checked with previous value.
                    while (left < right && arr[left] == arr[left-1]) {
                        left++;
                    }

                    // right is decremented, so check with next value
                    while(left < right && arr[right] == arr[right+1]) {
                        right --;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String []args) {
        // Input: nums = [-1,0,1,2,-1,-4]
        // Output: [[-1,-1,2],[-1,0,1]]

        int []nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(nums);
        for(List<Integer> ele : result) {
            System.out.println(ele);
        }
    }
}
