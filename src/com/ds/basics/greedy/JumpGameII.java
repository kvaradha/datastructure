package com.ds.basics.greedy;

/**
 * Code No: 45 - Jump Game - Number of steps
 *
 * @author Karthikeyan
 */
public class JumpGameII {

    /**
     * Jump Game II - Number of steps
     * @param jump int[]
     * @return int
     */
    public static int jumpGame(int []jump) {
        int currentIndex = 0;
        int max = 0;
        int steps = 0;
        //Skip last element.
        for(int i=0; i<jump.length-1; i++) {
            max = Math.max(max, i + jump[i]);
            if(max >= jump.length) {
                return steps + 1;
            }
            if(currentIndex == i) {
                if(max == currentIndex) {
                    // Trapped by zeros, cannot progress
                    return -1;
                }
                steps = steps + 1;
                currentIndex = max;
            }
        }
        return -1;
    }

    public static void main(String []args) {
        int []jump = {2,3,1,1,4};
        System.out.println(jumpGame(jump));
        jump = new int[]{3,2,1,0,4};
        System.out.println(jumpGame(jump));
        jump = new int[]{1, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(jumpGame(jump));
        jump = new int[]{3, 0, 0, 0, 99};
        System.out.println(jumpGame(jump));
        jump = new int[]{2, 2, 0, 0, 99};
        System.out.println(jumpGame(jump));
        jump = new int[]{2, 3, 0, 0, 0};
        System.out.println(jumpGame(jump));
        jump = new int[]{0, 2, 3};
        System.out.println(jumpGame(jump));
    }
}
