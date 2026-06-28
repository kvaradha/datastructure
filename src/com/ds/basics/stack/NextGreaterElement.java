package com.ds.basics.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Code No: 496 - Next Greater Element - I
 *
 * @author Karthikeyan
 */
public class NextGreaterElement {

    /**
     * Next Greater Element - I
     * @param nums1 []int
     * @param nums2 []int
     * @return []int
     */
    public static int[] nextGreaterElement(int []nums1, int []nums2) {
        HashMap<Integer, Integer> nextGreaterMap = nextGreaterElementMap(nums2);
        int []output = new int[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            output[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }
        return output;
    }

    /**
     * Next Greater Element Map
     *
     * @param nums2 int[]
     * @return HashMap
     */
    private static HashMap<Integer, Integer> nextGreaterElementMap(int []nums2) {
        //Track the next greater element(nge) - map(ele, nge)
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        List<Integer> stack = new ArrayList<>();
        int right = 0;
        while(right < nums2.length) {
            if(stack.isEmpty() || nums2[stack.getLast()] >= nums2[right]) {
                stack.addLast(right);
                right++;
            } else {
                // Generate Next Greater Element Hashmap
                // Fill current element. And its next greater element.
                nextGreaterMap.put(nums2[stack.removeLast()], nums2[right]);
            }
        }
        return nextGreaterMap;
    }

    public static void main(String []args) {
        // Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
        // Output: [-1,3,-1]
        int []nums1 = {4,1,2};
        int []nums2 = {1,3,4,2};
        Arrays.stream(nextGreaterElement(nums1, nums2)).forEach(System.out::println);
    }
}
