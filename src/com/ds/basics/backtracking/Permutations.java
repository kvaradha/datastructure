package com.ds.basics.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Code No: 46 - Permutations
 *
 * @author Karthikeyan
 */
public class Permutations {

    /**
     * Permutations
     *
     * @param nums int[]
     * @param res List<List<Integer>>
     * @param tracker List<Integer>
     */
    public static void permutations(int []nums, List<List<Integer>> res, List<Integer> tracker) {
       if(tracker.size() >= nums.length) {
           res.add(new ArrayList<>(tracker));
       }
       for(int num : nums) {
           if(!tracker.contains(num)) {
               // Add if not present.
               tracker.add(num);
               permutations(nums, res, tracker);
               // Remove once it is completed.
               tracker.removeLast();
           }
       }
    }

    public static void main(String []args) {
        int []nums = {1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        permutations(nums, res,  new ArrayList<>());
        for(List<Integer> list : res) {
            System.out.println(list.toString());
        }
    }
}
