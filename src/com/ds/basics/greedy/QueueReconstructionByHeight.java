package com.ds.basics.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Code No: 406 - Queue Reconstruction By Height
 *
 * @author Karthikeyan
 */
public class QueueReconstructionByHeight {

    /**
     * Queue Reconstruction
     *
     * @param people [][]int
     * @return [][]int
     */
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> {
            if(a[0] != b[0]) {
                return  b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i< people.length; i++) {
            list.add(people[i][1], people[i]);
        }

        int[][] res = new int[people.length][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }

    public static void main(String []args) {
        int [][]people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        //Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
        // Expected Output: 1 5 6 9 (since [1,3] and [2,5] merge into [1,5])
        Arrays.stream(reconstructQueue(people)).forEach((i) ->
                System.out.print(i[0] + " " + i[1] + " "));
    }

}
