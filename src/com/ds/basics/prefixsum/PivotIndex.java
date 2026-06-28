package com.ds.basics.prefixsum;

/**
 * Code No: 724 - Pivot Index
 *
 * @author Karthikeyan
 */
public class PivotIndex {

    public static int pivotIndex(int []a) {
        int rightSum = 0;
        for(int num : a) {
            rightSum = rightSum + num;
        }
        int leftSum=0;
        for(int i=0; i<a.length; i++) {
            rightSum = rightSum - a[i];
            if(leftSum == rightSum) {
                return i;
            }
            leftSum = leftSum + a[i];
        }
        return -1;
    }

    public static void main(String []args) {
        int []nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
}
