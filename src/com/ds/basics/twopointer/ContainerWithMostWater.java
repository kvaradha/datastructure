package com.ds.basics.twopointer;


/**
 * Code No: 11 - Container With Most Water
 *
 * @author Karthikeyan
 */
public class ContainerWithMostWater {

    /**
     * Container With Most Water.
     *
     * @param h int[]
     * @return int
     */
    public static int containerWithMostWater(int []h) {
        int left = 0;
        int right = h.length-1;
        int max = 0;
        while(left < right) {
            int height = Math.min(h[left], h[right]);
            int width = right - left;
            max = Math.max(max, height * width);
            if(h[left] < h[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String []args) {
        // Input: height = [1,8,6,2,5,4,8,3,7]
        // Output: 49
        int []h = {1,8,6,2,5,4,8,3,7};
        System.out.println(containerWithMostWater(h));
    }
}
