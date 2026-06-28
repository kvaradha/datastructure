package com.ds.basics.prefixsum;

import java.util.HashMap;

/**
 * Code No: 560 - Subarray Sum Equals K
 *
 * @author Karthikeyan
 */
public class SubArraySum {

    public static int subArraySum(int []a, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int currentPrefixSum = 0;
        int totalSubarrays = 0;
        map.put(0,1);
        for(int i=0; i<a.length; i++) {
            currentPrefixSum = currentPrefixSum + a[i];
            if (map.containsKey(currentPrefixSum - k)) {
                totalSubarrays = totalSubarrays + map.get(currentPrefixSum - k);
            }
            map.put(currentPrefixSum, map.getOrDefault(currentPrefixSum,0) + 1);
        }
        return totalSubarrays;
    }

    public static void main(String []args) {
        int []a = new int[] {1,1,1};
        System.out.println(subArraySum(a, 2));
        a = new int[] {2,2,1,1,3};
        System.out.println(subArraySum(a, 2));
    }
}
