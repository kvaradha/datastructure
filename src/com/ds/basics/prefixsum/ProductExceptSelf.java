package com.ds.basics.prefixsum;

import java.util.Arrays;

/**
 * Code No: 238 - Product Except Self.
 *
 * @author Karthikeyan
 */
public class ProductExceptSelf {

    /**
     * Product Except Self.
     *
     * @param nums int[]
     * @return int[]
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * postfix;
            postfix = postfix * nums[i];
        }
        return res;
    }

    public static void main(String []args) {
        int []nums = {1,2,3,4};
        Arrays.stream(productExceptSelf(nums)).forEach((e) -> System.out.print(e + " "));
    }
}
