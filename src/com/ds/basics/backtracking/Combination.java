package com.ds.basics.backtracking;

import java.util.*;

/**
 * Code No: 77 - Combination
 *
 * @author Karthikeyan
 */
public class Combination {

    /**
     * Combination
     * @param nums int[]
     * @param k int
     * @param start int
     * @param tracker List<Integer>
     * @param res List<List<Integer>>
     */
    public static void combination(int []nums, int k, int start, List<Integer> tracker, List<List<Integer>> res) {
        if(tracker.size() == k) {
            res.add(new ArrayList<>(tracker));
            return;
        }
        for(int i=start; i<nums.length; i++) {
            if(!tracker.contains(nums[i])) {
                tracker.add(nums[i]);
                combination(nums, k, i+1, tracker, res);
                tracker.removeLast();
            }
        }
    }

    public static void main(String []args) {
        int []nums = {1,2,3,4};
        int k = 2;
        List<List<Integer>> res = new ArrayList<>();
        combination(nums, k, 0, new ArrayList<>(), res);
        for(List<Integer> list : res) {
            System.out.println(list.toString());
        }
    }
}
