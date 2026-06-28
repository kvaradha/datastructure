package com.ds.basics.greedy;

/**
 * Code No: 55 - Jump Game
 *
 * @author Karthikeyan
 */
public class JumpGame {

    /**
     * Jump Game.
     *
     * @param jump int[]
     * @return boolean
     */
    public static boolean jumpGame(int []jump) {
        int endIndex = 0;
        int max = 0;
        for(int i=0; i<jump.length-1; i++) {
            max = Math.max(max, i + jump[i]);
            if(max >= jump.length -1) {
                return true;
            }
            if(endIndex == i) {
                //Handle zero effectively.
                if(i == max) {
                    // Trapped by zeros, cannot progress
                    return false;
                }
                endIndex = max;
            }
        }
        return false;
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
