package com.ds.basics.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Code No: 503 - Next Greater Element - II
 *
 * @author Karthikeyan
 */
public class NextGreaterElementII {

    /**
     * Next Greater Element II
     * @param nums1 int[]
     * @return int[]
     */
    public static int[] nextGreaterElement(int []nums1) {
        HashMap<Integer, Integer> nextGreaterMap = nextGreaterElementMap(nums1);
        int []output = new int[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            output[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }
        return output;
    }

    /**
     * Next Greater Element Map
     * @param nums int[]
     * @return HashMap<Integer, Integer>
     */
    public static HashMap<Integer, Integer> nextGreaterElementMap(int []nums) {
        HashMap<Integer, Integer> nextGreaterElementMap = new HashMap<>();
        List<Integer> stack = new ArrayList<>();
        int right = 0;
        int len = nums.length;
        while(right < len * 2) {
            int ri = right % len;
            if(stack.isEmpty() || nums[stack.getLast()] >= nums[ri] ) {
                stack.addLast(ri);
                right++;
            } else {
                nextGreaterElementMap.put(nums[stack.removeLast()],nums[ri]);
            }
        }
        return nextGreaterElementMap;
    }

    public static void main(String []args) {
        // Input: nums = [1,2,3,4,3]
        // Output: [2,3,4,-1,4]

        int []nums1 = {1,2,3,4,3};
        Arrays.stream(nextGreaterElement(nums1)).forEach(System.out::println);

    }
}
